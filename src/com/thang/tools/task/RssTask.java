package com.thang.tools.task;

import java.io.File;
import java.net.URI;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class RssTask implements Job{


	/**
	 * 任务内空：
	 * 从网上得到所有的rss的xml，并保存到rss文件夹中
	 */
	@Override
	public void execute(JobExecutionContext jobEc) throws JobExecutionException {
		
	}
	
	/**
	 * 得到百度的rss
	 */
	private void obtainBaiduRss(){
		
	}
	
	/**
	 * 
	 */
	private void obtainQQRss(){
		//国内新闻
		String[] urls={"http://news.qq.com/newsgn/rss_newsgn.xml"};
		try{
		    File file=null;
		    for(String url:urls){
			    file=new File(new URI(url));
			    
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
