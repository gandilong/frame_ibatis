package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;
import com.thang.tools.util.DateUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserManager extends BaseDao{

	/**
	 * 登陆查询方法
	 * @param login_name
	 * @param login_pass
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultValues login(String login_name,String login_pass){
		ActionValues values=new ActionValues();
		values.put("loginName", login_name);
		values.put("loginPass", login_pass);
		values.offPage();
		return get("system.user.login",values);
	}
	
	/**
	 * 通用常询方法
	 * @param values
	 * @return
	 */
	public List<ResultValues> query(ActionValues values){
		return list("system.user.query", values);
	}
	
	/**
	 * 保存方法
	 * @param values
	 */
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void toInsert(ActionValues values){
		values.put("createTime", DateUtils.getSystime());
		getSqlSession().insert("system.user.toInsert", values);
	}
	
	/**
	 * 得到一条用户记录
	 * @param values
	 * @return
	 */
	public ResultValues get(ActionValues values){
		return get("system.user.query", values);
	}
	
	/**
	 * 更新方法
	 * @param values
	 */
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void toUpate(ActionValues values){
		getSqlSession().update("system.user.toUpdate", values);
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void toDelete(ActionValues values){
		getSqlSession().delete("system.user.toDelete", values);
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void toDeletes(ActionValues values){
		getSqlSession().delete("system.user.toDeletes",values);
	}
	
	
}
