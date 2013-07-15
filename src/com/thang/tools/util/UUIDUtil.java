package com.thang.tools.util;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class UUIDUtil {

	public static String getUUID(){
		return StringUtils.join(UUID.randomUUID().toString().split("-"),"");
	}
	
}
