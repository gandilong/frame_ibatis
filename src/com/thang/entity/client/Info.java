package com.thang.entity.client;

public class Info {

	private String title;
	private String link;
	private String author;
	private String description;
	private String date;
	
	public Info(){}
	
	public Info(String t,String k,String a,String d,String e){
		this.title=t;
		this.link=k;
		this.author=a;
		this.description=d;
		this.date=e;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
