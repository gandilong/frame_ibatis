package com.thang.tools.auth;

import org.apache.commons.codec.digest.DigestUtils;
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

import com.thang.service.system.ResourceManager;
import com.thang.service.system.RoleManager;
import com.thang.service.system.UserManager;
import com.thang.tools.model.ResultValues;

@Component("dbRealm")
public class DBRealm extends JdbcRealm{
	
	@Autowired
	private ResourceManager resourceManager;
	@Autowired
	private RoleManager roleManager;
	@Autowired
	private UserManager userManager;


	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		ShiroUser shiroUser = (ShiroUser) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roleManager.getRoleNameByUser(shiroUser.getId()));
		info.addStringPermissions(resourceManager.getResourceNameByUser(shiroUser.getId()));
		return info;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		ResultValues user=null; 
		try{
			token.setPassword(DigestUtils.md5Hex(token.getPassword()==null?"":String.valueOf(token.getPassword())).toCharArray());
		    user=userManager.login(token.getUsername(),String.valueOf(token.getPassword()));
		}catch(Exception e){
			e.printStackTrace();
		}
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
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
