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
public class Page {
    
	private int total=0;//总记录数
	private int pageNum=0;//总页数
	private int pageSize=30;//每页条数
	private int pageNow=1;//当前页码
	
	private String order="DESC";//ASC or DESC
	private String orderBy;
	
	private List<ResultValues> result;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
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

	public List<ResultValues> getResult() {
		return result;
	}

	public void setResult(List<ResultValues> result) {
		this.result = result;
	}
	
}
