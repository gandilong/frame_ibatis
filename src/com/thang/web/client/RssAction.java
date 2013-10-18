package com.thang.web.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.thang.entity.client.Info;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.util.ConfigUtils;
import com.thang.utils.lang.DateUtils;

@Controller
@RequestMapping("client/rss")
public class RssAction extends Action{

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public void index(){
		
		ActionValues values=getValues();
		values.clear();
		
		SyndFeedInput sfInput=new SyndFeedInput();
		
		try{
			File[] dirs=new File(ConfigUtils.getConfig("rss_dir")).listFiles();
			
			XmlReader reader=null;
			
			for(File f:dirs){
				reader=new XmlReader(f);
				
				List<SyndEntry> entries=sfInput.build(reader).getEntries().subList(0, 3);
				List<Info> infos=new ArrayList<Info>();
				for(SyndEntry e:entries){
					infos.add(new Info(e.getTitle(),e.getLink(),e.getAuthor(),e.getDescription().getValue(),DateUtils.formatDate(e.getPublishedDate()==null?new Date():e.getPublishedDate(),DateUtils.YYYY_MM_DD_HH_mm_ss)));
				}
				values.put(f.getName().substring(0, f.getName().indexOf(".")),infos);
			}
			
			printJSON(values);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
