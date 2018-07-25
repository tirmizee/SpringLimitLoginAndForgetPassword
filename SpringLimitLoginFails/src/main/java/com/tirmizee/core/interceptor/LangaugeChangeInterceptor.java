package com.tirmizee.core.interceptor;

import java.util.Locale;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class LangaugeChangeInterceptor extends LocaleChangeInterceptor {
	
	@Override
	protected Locale parseLocaleValue(String locale) {
		String repairedLocel = locale.replaceAll("'", "");
		if ("TH".equalsIgnoreCase(repairedLocel)) {
			return new Locale("th");
		}
		return Locale.ENGLISH;
	}
	
}
