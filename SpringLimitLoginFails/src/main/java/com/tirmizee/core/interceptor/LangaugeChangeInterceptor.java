package com.tirmizee.core.interceptor;

import java.util.Locale;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class LangaugeChangeInterceptor extends LocaleChangeInterceptor {
	
	@Override
	protected Locale parseLocaleValue(String locale) {
		String prepareLocel = locale.replaceAll("'", "");
		if ("TH".equalsIgnoreCase(prepareLocel)) {
			return new Locale("th");
		}
		return Locale.ENGLISH;
	}
	
}
