package com.thang.tools.auth;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import com.thang.tools.model.Constants;

public class SysUserFilter extends PathMatchingFilter {

	
	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		
		ShiroUser user=(ShiroUser)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(Constants.CURRENT_USER, user);
		return true;
	}
}
