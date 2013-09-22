package com.thang.tools.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.thang.tools.util.StrUtils;


@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})  
public class PaginationInterceptor implements Interceptor {

	
	private static String dialect=null;//数据库方言
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY=new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY=new DefaultObjectWrapperFactory();
	private static Logger logger=Logger.getLogger(PaginationInterceptor.class);
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		 StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
		 Object paramObj=statementHandler.getParameterHandler().getParameterObject();
		 MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		 
	     // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环  
	     // 可以分离出最原始的的目标类)  
		 
	     while (metaStatementHandler.hasGetter("h")) {  
	         Object object = metaStatementHandler.getValue("h");  
	         metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);  
	     }  
	     
	     // 分离最后一个代理对象的目标类  
	     while (metaStatementHandler.hasGetter("target")) {  
	         Object object = metaStatementHandler.getValue("target");  
	         metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);  
	     }
	     
	     //Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");  
	     
	     
	     MappedStatement mappedStatement = (MappedStatement)   
	     metaStatementHandler.getValue("delegate.mappedStatement");  
	     // 只要参数对象里Page对象或 page=on字段就进行分页。 
	     if (null!=paramObj) {
	    	 boolean toPage=false;
	    	 Object page=null;
	    	 if(paramObj instanceof ActionValues){
	    	    page=PropertyUtils.getProperty(paramObj, "fpage");	 
	    	 }
	    	 if(null!=page&&(page instanceof String)&&"on".equals(String.valueOf(page).trim())){
	    		 BeanUtils.setProperty(paramObj, "fpage", page=new Page());
	    		 toPage=true;
	    	 }else if(null!=page&&page instanceof Page){
	    		 toPage=true;
	    	 }
	    	 
	    	 if(toPage){
	    		 BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
		          
		             String sql = boundSql.getSql();  
		             String pageSql = buildPageSql(sql, (Page)page);  
		             metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);  
		             // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数  
		             metaStatementHandler.setValue("delegate.rowBounds.offset",RowBounds.NO_ROW_OFFSET);  
		             metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);  
		             Connection connection = (Connection) invocation.getArgs()[0];  
		             // 重设分页参数里的总页数等  
		             setPageParameter(sql, connection, mappedStatement, boundSql, (Page)page);  
	    	 }
	     }  
	    
	     //打印SQL及参数  
	     System.out.println(statementHandler.getBoundSql().getSql());
	     List<ParameterMapping> ps=statementHandler.getBoundSql().getParameterMappings();
	     for(ParameterMapping p:ps){
	    	 if((paramObj instanceof Integer)||(paramObj instanceof Long)||(paramObj instanceof String)||(paramObj instanceof Boolean)){
	    		 System.out.print(p.getProperty()+":"+paramObj+"  ");	 
	    	 }else{
	    	     System.out.print(p.getProperty()+":"+BeanUtils.getProperty(paramObj, p.getProperty())+"  ");
	    	 }
	     }
	     System.out.println();
	     
	     // 将执行权交给下一个拦截器  
	     return invocation.proceed();  
	}
	
    private String buildPageSql(String sql, Page page) {  
        if (page != null) {  
            StringBuilder pageSql = new StringBuilder();  
            if ("mysql".equals(dialect)) {  
                pageSql = buildPageSqlForMysql(sql, page);  
            } else if ("oracle".equals(dialect)) {  
                pageSql = buildPageSqlForOracle(sql, page);  
            } else {  
                return sql;  
            }  
            return pageSql.toString();  
        } else {  
            return sql;  
        }  
    }  
    
    
    public StringBuilder buildPageSqlForMysql(String sql, Page page) {  
        StringBuilder pageSql = new StringBuilder(100);  
        String beginrow = String.valueOf((page.getPageNow()- 1) * page.getPageSize());  
        pageSql.append(sql);  
        pageSql.append(" order by "+page.getOrderBy()+" "+page.getOrder());
        pageSql.append(" limit " + beginrow + "," + page.getPageSize());  
        return pageSql;  
    }  
    
    public StringBuilder buildPageSqlForOracle(String sql, Page page) {  
        StringBuilder pageSql = new StringBuilder(100);  
        String beginrow = String.valueOf((page.getPageNow() - 1) * page.getPageSize());  
        String endrow = String.valueOf(page.getPageNow() * page.getPageSize());  
        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");  
        pageSql.append(sql);
        pageSql.append(" order by "+page.getOrderBy()+" "+page.getOrder());
        pageSql.append(" ) temp where rownum <= ").append(endrow);  
        pageSql.append(") where row_id > ").append(beginrow);  
        return pageSql;  
    }  
	
    /** 
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用  
     * 者就可用通过 分页参数<code>PageParameter</code>获得相关信息。 
     *  
     * @param sql 
     * @param connection 
     * @param mappedStatement 
     * @param boundSql 
     * @param page 
     */  
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,BoundSql boundSql, Page page) {  
        // 记录总记录数  
        String countSql = "select count(0) from (" + sql + ") as total";  
        PreparedStatement countStmt = null;  
        ResultSet rs = null;  
        try {  
            countStmt = connection.prepareStatement(countSql);  
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,  
                    boundSql.getParameterMappings(), boundSql.getParameterObject());  
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());  
            rs = countStmt.executeQuery();  
            int totalCount = 0;  
            if (rs.next()) {  
                totalCount = rs.getInt(1);  
            }  
            page.setTotal(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);  
            page.setPageNum(totalPage);
        } catch (SQLException e) {  
            logger.error("Ignore this exception", e);  
        } finally {  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                logger.error("Ignore this exception", e);  
            }  
            try {  
                countStmt.close();  
            } catch (SQLException e) {  
                logger.error("Ignore this exception", e);  
            }  
        }  
    }  
	
	/** 
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler 
     * @param ps 
     */  
    private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {  
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
	    parameterHandler.setParameters(ps); 
    }  
      

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {  
	        return Plugin.wrap(target, this);  
	    } else {  
	        return target;  
	    }  
	}

	@Override
	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");  
        if (StrUtils.isEmpty(dialect)) {
        	dialect="mysql";
        }  
	}

}
