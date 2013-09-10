package com.thang.tools.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thang.entity.system.User;
import com.thang.service.system.AuthManager;

@Component("dbRealm")
public class DBRealm extends AuthorizingRealm{

	private AuthManager auth;

	 

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		ShiroUser shiroUser = (ShiroUser) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(auth.getRoleByUser(shiroUser.getId()));
		return info;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user=auth.getUserByName(token.getUsername());
		token.setRememberMe(true);
		if (null!=user) {
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getUserName(), user.getLoginName()),user.getLoginPass(),getName());
		} 
		return null;
	}

	@Autowired
	public void setAuth(AuthManager auth) {
		this.auth = auth;
	}
	
}
