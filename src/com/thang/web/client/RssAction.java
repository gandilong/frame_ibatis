package com.thang.web.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.thang.entity.client.Info;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.utils.lang.DateUtils;

@Controller
@RequestMapping("client/rss")
public class RssAction extends Action{

	
	
	@RequestMapping("/")
	public void index(){
		
		ActionValues values=getValues();
		values.clear();
		
		SyndFeedInput sfInput=new SyndFeedInput();
		
		try{
			//科技头条
			URL kjtt=new URL("http://tech.163.com/special/000944OI/headlines.xml");
			
			//互联网
			URL hlw=new URL("http://tech.163.com/special/000944OI/hulianwang.xml");
			
			//IT界
			URL itj=new URL("http://tech.163.com/special/000944OI/kejiyejie.xml");
			
			//深度阅读
			URL sdyd=new URL("http://tech.163.com/special/000944OI/shenduyuedu.xml");
			
			
			XmlReader reader_kjtt=new XmlReader(kjtt);
			XmlReader reader_hlw=new XmlReader(hlw);
			XmlReader reader_itj=new XmlReader(itj);
			XmlReader reader_sdyd=new XmlReader(sdyd);
			
			List<SyndEntry> entries=sfInput.build(reader_kjtt).getEntries().subList(0, 1);
			List<Info> kjjtList=new ArrayList<Info>();
			for(SyndEntry e:entries){
				kjjtList.add(new Info(e.getTitle(),e.getLink(),e.getAuthor(),e.getDescription().getValue(),DateUtils.formatDate(e.getPublishedDate(),DateUtils.YYYY_MM_DD_HH_mm_ss)));
			}
			
			entries=sfInput.build(reader_hlw).getEntries().subList(0, 1);
			List<Info> hlwList=new ArrayList<Info>();
			for(SyndEntry e:entries){
				hlwList.add(new Info(e.getTitle(),e.getLink(),e.getAuthor(),e.getDescription().getValue(),DateUtils.formatDate(e.getPublishedDate(),DateUtils.YYYY_MM_DD_HH_mm_ss)));
			}
			
			entries=sfInput.build(reader_itj).getEntries().subList(0, 1);
			List<Info> itjList=new ArrayList<Info>();
			for(SyndEntry e:entries){
				itjList.add(new Info(e.getTitle(),e.getLink(),e.getAuthor(),e.getDescription().getValue(),DateUtils.formatDate(e.getPublishedDate(),DateUtils.YYYY_MM_DD_HH_mm_ss)));
			}
			
			entries=sfInput.build(reader_sdyd).getEntries().subList(0, 1);
			List<Info> sdydList=new ArrayList<Info>();
			for(SyndEntry e:entries){
				sdydList.add(new Info(e.getTitle(),e.getLink(),e.getAuthor(),e.getDescription().getValue(),DateUtils.formatDate(e.getPublishedDate(),DateUtils.YYYY_MM_DD_HH_mm_ss)));
			}
			
			
			values.put("kjtt",kjjtList);
			values.put("hlw",hlwList);
			values.put("itj",itjList);
			values.put("sdyd",sdydList);

			
			reader_kjtt.close();
			reader_hlw.close();
			reader_itj.close();
			reader_sdyd.close();
			
			printJSON(values);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
