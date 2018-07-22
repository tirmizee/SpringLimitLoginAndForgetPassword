package com.tirmizee.core.component;

import java.net.URL;

public class ResourceHelper {
	
	public static String getPath(String name){
		return ResourceHelper.class.getClassLoader().getResource(name).getPath();
	};
	
	public static URL getResource(String name){
		return ResourceHelper.class.getClassLoader().getResource(name);
	};
	
}
