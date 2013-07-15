/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;
import com.thang.tools.model.Pages;

/**
 *
 * @author Gandilong
 */
@Component
public class TestService extends BaseDao{
    
    public DataValues get(ActionValues values){
        return queryForObject("test.query",values);
    }
    
    public List<DataValues> list(ActionValues values){
        return queryForList("test.query",values);
    }
    
    public Pages query(ActionValues values,Pages page){
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
