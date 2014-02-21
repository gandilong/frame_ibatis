package com.thang.tools.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.thang.tools.mate.Table;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;
import com.thang.tools.util.SQLGener;

/**
 * 底层采用Spring JdbcTemplate
 * @author gandilong
 *
 */
public class BaseDao extends Dao{

	private static JdbcTemplate jdbcTemplate;
	
	private static NamedParameterJdbcTemplate nameParameterJdbcTemplate;
	
	/**
	 * 简单的执行一条sql语句。
	 * @param sql
	 */
	public void execute(String sql){
		jdbcTemplate.execute(sql);
	}
	
	/**
	 * 根据sql查询出数据条数。例如 select * from user;
	 * @param sql
	 * @return
	 */
	public long total(String sql){
		return jdbcTemplate.queryForObject("select count(0) from ("+sql+")", long.class);
	}
	
	/**
	 * 返回指定表的总记录数
	 * @param cls
	 * @return
	 */
	@Deprecated
	public int total(Class<?> cls){
		final String tableName=cls.getAnnotation(Table.class).value();
		return jdbcTemplate.execute(new PreparedStatementCreator() {  
			       @Override  
			       public PreparedStatement createPreparedStatement(Connection conn)throws SQLException {  
			           return conn.prepareStatement("select count(0) from "+tableName);  
			       }
		       },new PreparedStatementCallback<Integer>() {  
		           @Override  
		           public Integer doInPreparedStatement(PreparedStatement pstmt)throws SQLException, DataAccessException {  
		               pstmt.execute();  
		               ResultSet rs = pstmt.getResultSet();  
		               rs.next();  
		               return rs.getInt(1);  
	               }
		      });      
	}
	
	/**
     * 新增记录,ID手动设置,用该方法时，实体类必须加注解。
     * @param cls
     * @param values
     */
	@Deprecated
	public void insert(Object obj){
		ActionValues values=new ActionValues(obj);
		insert(obj.getClass(),values);
	}
	
    /**
     * 新增记录,ID手动设置,用该方法时，实体类必须加注解。
     * @param cls
     * @param values
     */
	@Deprecated
	public void insert(Class<?> cls,ActionValues values){
		nameParameterJdbcTemplate.update(SQLGener.insertSQL(cls), values);
	}
	
	/**
	 * 手动新增,ID手动设置,书写格式 例如：insert into user(id,name,age) values(:id,:name:values)
	 * @param cls
	 * @param values
	 */
	public void insert(String sql,ActionValues values){
		nameParameterJdbcTemplate.update(sql, values);
	}
	
	/**
	 * 根据主键删除,用该方法时，实体类必须加注解。
	 * @param cls
	 * @param id
	 */
	@Deprecated
    public void delete(Class<?> cls,long id){
    	jdbcTemplate.execute(SQLGener.deleteSQL(cls, id));
    }
    
    /**
	 * 根据主键删除,用该方法时，实体类必须加注解。
	 * @param cls
	 * @param id
	 */
	@Deprecated
    public void delete(Class<?> cls,String id){
    	jdbcTemplate.execute(SQLGener.deleteSQL(cls, id));
    }
    
    /**
     * 书写格式  例如：delete from user where id=:id and name=:name
     * @param sql
     * @param values
     */
    public void delete(String sql,ActionValues values){
    	nameParameterJdbcTemplate.update(sql, values);
    }
    
    /**
     * 执行增加，删除，修改语句
     * @param sql
     * @param values
     */
    public void update(String sql,ActionValues values){
    	nameParameterJdbcTemplate.update(sql, values);
    }
    
    /**
     * 查询一条记录，如果是多条，则返回第一条。
     */
    public ResultValues getResult(String sql,ActionValues values){
    	List<ResultValues> result=queryResult(sql,values);
    	if(null!=result&&result.size()>0){
    		return result.get(0);
    	}
    	return null;
    }
    
    /**
     * 针对简单的查询
     * @param sql
     * @param values
     * @return
     */
    public List<ResultValues> queryResult(String sql,ActionValues values){
    	nameParameterJdbcTemplate.query(sql, values, new RowMapper<ResultValues>(){
			@Override
			public ResultValues mapRow(ResultSet result, int index) throws SQLException {
				ResultSetMetaData meta=result.getMetaData();
				int columnNum=meta.getColumnCount();
				ResultValues values=new ResultValues();
				for(int i=1;i<=columnNum;i++){
					values.put(meta.getColumnName(i),result.getString(i));
				}
				return values;
			}
    		
    	});
    	return null;
    }
    
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
    	if(null==jdbcTemplate||null==nameParameterJdbcTemplate){
    		BaseDao.jdbcTemplate = new JdbcTemplate(dataSource);
    		BaseDao.nameParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    	}
    }
    
}
