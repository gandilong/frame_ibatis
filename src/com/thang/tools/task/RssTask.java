package com.thang.tools.task;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.input.XmlStreamReader;
import org.apache.commons.io.output.XmlStreamWriter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.thang.tools.util.ConfigUtils;


public class RssTask implements Job{


	/**
	 * 任务内空：
	 * 从网上得到所有的rss的xml，并保存到rss文件夹中
	 */
	@Override
	public void execute(JobExecutionContext jobEc) throws JobExecutionException {
		obtainBaiduRss();
		obtainQQRss();
	}
	
	/**
	 * 得到百度的rss
	 */
	private void obtainBaiduRss(){
		
	}
	
	private void obtainQQRss(){
		//国内新闻
		String[] urls={
				        "http://news.qq.com/newsgn/rss_newsgn.xml",
				        "http://sports.qq.com/rss_newssports.xml",
				        "http://digi.tech.qq.com/mobile/mobilepk/rss_mobilepk.xml"
		              };
		try{
		    
		    char[] cs=new char[1];
		    int k=0;
		    
		    XmlStreamReader xmlReader=null;
		    XmlStreamWriter xmlWriter=null;
		    for(String url:urls){
			    if(null!=xmlReader){
			    	xmlReader.close();
			    }
			    if(null!=xmlWriter){
			    	xmlWriter.close();
			    }
			    xmlReader=new XmlStreamReader(new URL(url));
			    xmlWriter=new XmlStreamWriter(new File(ConfigUtils.getConfig("rss_dir")+"/"+url.substring(url.lastIndexOf("/"))));
			    k=0;
			    while(-1!=k){
			    	k=xmlReader.read(cs);
			    	xmlWriter.write(cs);
			    }
		    }
		    
		    xmlReader.close();
		    xmlWriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
