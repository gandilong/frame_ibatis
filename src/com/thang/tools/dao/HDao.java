package com.thang.tools.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 底层采用Hibernate
 * @author Gandilong
 */
public class HDao<T> {

	public void insertOrUpdate(T t){
		getSession().saveOrUpdate(t);
	}
	
	public void delete(T t){
		getSession().delete(t);
	}
	
	
	@Autowired  
    @Qualifier("sessionFactory")  
    private SessionFactory sessionFactory;  
   
    public Session getSession() {  
        //事务必须是开启的，否则获取不到  
        return sessionFactory.getCurrentSession();  
    }  
}
