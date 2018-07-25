package com.tirmizee.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.core.security.AuthenticationFailureHandlerImpl;
import com.tirmizee.core.security.AuthenticationProviderImpl;
import com.tirmizee.core.security.AuthenticationSuccessHandlerImpl;
import com.tirmizee.core.security.HttpSessionCsrfTokenRepositoryImpl;
import com.tirmizee.core.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String FORCE_CHANGE_PASSWAORD = "FORCE_CHANGE_PASSWAORD";
	
	public static final String CHANGE_PASSWAORD_EXPIRED = "CHANGE_PASSWAORD_EXPIRED";

	@Autowired
	private MemberDao memberDao;
	
	@Autowired 
	private PermissionDao permissionDao;
	
	@Autowired
	private AccessDeniedHandler  accessDeniedHandler;

	@Autowired
	private AuthenticationSuccessHandlerImpl successHandler;
	
	@Autowired
	private AuthenticationFailureHandlerImpl failureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new AuthenticationProviderImpl();
	    authProvider.setHideUserNotFoundExceptions(false);
	    authProvider.setUserDetailsService(userDetailsService());
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl(memberDao, permissionDao);
	}
	
	@Bean
	public CsrfTokenRepository csrfTokenRepository(){
		return new HttpSessionCsrfTokenRepositoryImpl();
	}
	
	@Bean
	public SessionRegistry sessionRegistry(){
		return new SessionRegistryImpl();
	} 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

			.csrf().csrfTokenRepository(csrfTokenRepository())
			
			.and()
			.authorizeRequests()
				
				.antMatchers( "/login",
							  "/ForgetPassword",
							  "/Register",
							  "/ForcePasswordChangeExpired",
							  "/api/password/forget",
							  "/api/password/reset",
							  "/api/member/register",
							  "/ResetPassword/**").permitAll()
				
				.antMatchers( "/api/password/forceChange").hasAuthority(FORCE_CHANGE_PASSWAORD)
				
				.antMatchers( "/api/password/change").hasAuthority(CHANGE_PASSWAORD_EXPIRED)
				
				.anyRequest().authenticated()
			
			.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
			
			.and()
		    .formLogin().loginPage("/login").permitAll()
		    	.successHandler(successHandler)
		    	.failureHandler(failureHandler)
		    	
		    .and()
		    .sessionManagement()
			    .maximumSessions(1)
			    .maxSessionsPreventsLogin(true)
			    .sessionRegistry(sessionRegistry());
	}

}
 