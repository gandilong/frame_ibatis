/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.tools.model;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class Pages {
    
	private long total=0;//总记录数
	private long pageNum=0;//总页数
	private long pageSize=15;//每页条数
	private long pageNow=1;//当前页码
	
	private String order="DESC";//ASC or DESC
	private String orderBy;
	
	private List<DataValues> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNow() {
		return pageNow;
	}

	public void setPageNow(long pageNow) {
		this.pageNow = pageNow;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<DataValues> getResult() {
		return result;
	}

	public void setResult(List<DataValues> result) {
		this.result = result;
	}
	
}
