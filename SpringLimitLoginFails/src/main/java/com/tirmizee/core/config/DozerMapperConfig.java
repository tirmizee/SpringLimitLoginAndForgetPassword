package com.tirmizee.core.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.core.component.IMapper;
import com.tirmizee.core.component.IMapperImpl;


@Configuration
public class DozerMapperConfig {
	
	@Bean	
	public IMapper getCustomMapper(){
		return new IMapperImpl(Arrays.asList("dozer-config.xml"));
	}

}