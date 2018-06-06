package com.tirmizee.core.component;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


public class MessageSourceUtilsImpl extends ReloadableResourceBundleMessageSource implements MessageSourceUtils {
	
	@Override
	public String getMessage(String code, Object...args) {
		return getMessage(code, args, LocaleContextHolder.getLocale());
	}
	
	@Override
	public String getMessage(Locale locale, String code, Object...args) {
		return getMessage(code, args, locale);
	}

	@Override
	public String getMessageOrDefault(String defaultMessage, Locale locale, String code, Object...args) {
		return getMessage(code, args, defaultMessage, locale);
	}

	@Override
	public String getMessageOrDefault(String defaultMessage, String code, Object...args) {
		return getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
	}

}
