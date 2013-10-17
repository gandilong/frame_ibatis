package com.thang.tools.task;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * 
 * @author gandilong
 *
 */
public class Task {

	private SchedulerFactory schedFact =null;
	private Scheduler sche=null;
	
	public Task(){
		init();
	}
	
	/**
	 * 初始化任务调度器
	 */
	public void init(){
		try{
		    schedFact=new org.quartz.impl.StdSchedulerFactory();

		    sche = schedFact.getScheduler();

		    sche.start();
		    initJobs();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public void initJobs(){
		
		 //创建rss任务
		  JobDetail job = JobBuilder.newJob(RssTask.class).withIdentity("rssJob", "thangJobs").build();

		  //创建rss触发器：马上执行任务，并每隔12小后再执行。
		  Trigger trigger = TriggerBuilder.newTrigger()
				                          .withIdentity("rssTrigger", "thangTriggers")
				                          .startNow()
		                                  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(12).repeatForever())
		                                  .build();

		  try{
		      //告诉 quartz用指定的触发器执行
		      sche.scheduleJob(job, trigger);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		
	}
	
	
}
 
