package com.thang.tools.model;

import java.util.List;
import java.util.Map;

/**
 * 通用树模型，适用于jquery easyUI
 * @author gandilong
 *
 */
public class Tree {

	private int id;
	private String text;
	private String state;//closed|open
	private Map<String,String> attributes;
	private List<Tree> children;
	
	public Tree(){}
	
	public Tree(int id,String txt){
		this.id=id;
		this.text=txt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	
	
}
