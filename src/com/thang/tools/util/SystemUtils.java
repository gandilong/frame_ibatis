package com.thang.tools.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.thang.tools.auth.ShiroUser;

public class SystemUtils {

	
	public static ShiroUser getUser(){
		Subject sub=SecurityUtils.getSubject();
		if(null==sub||null==sub.getPrincipal()){
			return null;
		}
		return (ShiroUser)sub.getPrincipal();
	}
	
}
