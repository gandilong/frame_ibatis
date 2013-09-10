package com.thang.tools.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;
import com.thang.tools.model.Pages;

/**
 *
 * @author Gandilong
 */
public class Dao extends SqlSessionDaoSupport {
    
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	/**
    public DataValues queryForObject(String sqlStr,ActionValues values){
        DataValues result=(DataValues)getSqlMapClientTemplate().queryForObject(sqlStr, values);
        result.formatKey();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public List<DataValues> queryForList(String sqlStr,ActionValues values){
        List<DataValues> resultList=null;
        List<DataValues> list=getSqlMapClientTemplate().queryForList(sqlStr,values);
        if(null!=list){
            resultList=new ArrayList<DataValues>();
            for(DataValues data:list){            
                data.formatKey();
                resultList.add(data);
            }
        }
        return resultList;
    }
    
    public Pages queryForPage(String sqlStr,ActionValues values,Pages page){
        if(null==values){
            values=new ActionValues();
        }
        long totalRows=0;
        totalRows=queryCount(sqlStr,values);
        page.setTotal(totalRows);
        List<DataValues> result=null;
        if(totalRows>0){
            result=new ArrayList<DataValues>();
            String sqlHeader="SELECT tt.* FROM (SELECT r.*,ROWNUM rm FROM(";
            String sqlFooter=") r WHERE ROWNUM<="+page.getPageNow()*page.getPageSize()+" ) tt WHERE rm>"+(page.getPageNow()<=1?0:page.getPageNow()-1)*page.getPageSize();
            
            values.put("sqlHeader",sqlHeader);
            values.put("sqlFooter",sqlFooter);
            long startTime=System.currentTimeMillis();
            result=queryForList(sqlStr,values);
            System.out.println("查询耗时："+(System.currentTimeMillis()-startTime));
            page.setResult(result);
        }
        return page;
    }
    
    @SuppressWarnings("unchecked")
    public long queryCount(String sqlStr,ActionValues values){
        String sqlHeader="SELECT COUNT(*) resultCount FROM (\n";
        String sqlFooter=" \n) rc";
        values.put("sqlHeader",sqlHeader);
        values.put("sqlFooter",sqlFooter);
        long totalRows=0;
        Map<String,Object> dv=(Map<String,Object>)getSqlMapClientTemplate().queryForObject(sqlStr,values);
        totalRows=Long.valueOf(String.valueOf(dv.get("RESULTCOUNT")==null?"0":dv.get("RESULTCOUNT")));
        return totalRows;
    }**/
    
}
