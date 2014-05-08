package com.thang.tools.auth;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 并发人数控制
 * @author gandilong
 *
 */
public class KickoutSessionControlFilter extends AccessControlFilter {

	private String kickoutUrl;//踢出后的地址
	private boolean kickoutAfter=false;//踢出之前登陆/之后登陆的用户，默认踢出之前登陆的用户
	private int maxSession=1;//同一个账号最大会话数，默认为1
	
	private SessionManager sessionManager;
	private Cache<String,Deque<Serializable>> cache;
	
	@Override
	protected boolean isAccessAllowed(ServletRequest arg0,
			ServletResponse arg1, Object arg2) throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		Subject subject=getSubject(request, response);
		if(!subject.isAuthenticated()&&!subject.isRemembered()){
			//如果没有登陆，直接进行之后的流程。
			return true;
		}
		
		Session session=subject.getSession();
		ShiroUser user=(ShiroUser)subject.getPrincipal();
		Serializable sessionId=session.getId();
		
		//同步控制
		Deque<Serializable> deque=cache.get(user.getLoginName());
		if(null==deque){
			deque=new LinkedList<Serializable>();
			cache.put(user.getLoginName(), deque);
		}
		
		//如果队列里没有此sessionId，且用户没有被踢出：放入队列
		if(!deque.contains(sessionId)&&null==session.getAttribute("kickout")){
			deque.push(sessionId);
		}
		
		//如果队列里的sessionId数超出最大会话数，开始踢人
		while(deque.size()>maxSession){
			Serializable kickoutSessionId=null;
			if(kickoutAfter){//如果踢出后者
				kickoutSessionId=deque.removeFirst();
			}else{
				kickoutSessionId=deque.removeLast();
			}
			try{
				Session kickoutSession=sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
				if(null!=kickoutSession){
					//设置会话的kickout属性表示踢出了
					kickoutSession.setAttribute("kickout", true);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//如果被踢出了，直接退出，重定向到踢出后的地址
		if(null!=session.getAttribute("kickout")){
			//会话被踢出了
			try{
				subject.logout();
			}catch(Exception e){
				e.printStackTrace();
			}
			saveRequest(request);
			WebUtils.issueRedirect(request,response,kickoutUrl);
			return false;
		}
		
		return true;
	}

	public String getKickoutUrl() {
		return kickoutUrl;
	}

	public void setKickoutUrl(String kickoutUrl) {
		this.kickoutUrl = kickoutUrl;
	}

	public boolean isKickoutAfter() {
		return kickoutAfter;
	}

	public void setKickoutAfter(boolean kickoutAfter) {
		this.kickoutAfter = kickoutAfter;
	}

	public int getMaxSession() {
		return maxSession;
	}

	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public Cache<String, Deque<Serializable>> getCache() {
		return cache;
	}

	public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

	
}
