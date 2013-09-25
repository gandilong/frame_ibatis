package com.thang.tools.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thang.service.system.AuthManager;
import com.thang.service.system.UserManager;
import com.thang.tools.model.DataValues;

@Component("dbRealm")
public class DBRealm extends JdbcRealm{
	
	@Autowired
	private AuthManager authManager;
	@Autowired
	private UserManager userManager;


	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		ShiroUser shiroUser = (ShiroUser) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(authManager.getRoleNameByUser(shiroUser.getId()));
		info.addStringPermissions(authManager.getResourceNameByUser(shiroUser.getId()));
		return info;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		DataValues user=userManager.login(token.getUsername(),new String(token.getPassword()));
		if(token.isRememberMe()){
			token.setRememberMe(true);	
		}
		if (null!=user) {
			SimpleAuthenticationInfo auth=new SimpleAuthenticationInfo(new ShiroUser(user.getLong("id"),user.getStr("userName"), user.getStr("loginName")),user.getStr("loginPass"),getName());
			return auth;
		} 
		return null;
	}
	
	
	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}
	
	
	

}
