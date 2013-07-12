/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.service;

/**
 *
 * @author Administrator
 */
@Component
public class TestService {
    
    public DataValues get(ActionValues values){
        return queryForObject("test.query",values);
    }
    
    public List<DataValues> list(ActionValues values){
        return queryForList("test.query",values);
    }
    
    public List<DataValues> query(ActionValues values,Pages page){
        return queryForPage("test.query",values,page);
    }
    
    public void insert(ActionValues values){
        getSqlMapClientTemplate().insert("test.insertTest",values);
    }
    
    public void update(ActionValues values){
        getSqlMapClientTemplate().update("test.updateTest",values);
    }
    
    public void delete(String id){
        getSqlMapClientTemplate().delete("test.deleteTest",id);
    }
}
