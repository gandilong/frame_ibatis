package com.thang.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.tools.model.Action;

@Controller("system")
@RequestMapping("test")
public class UploadActionTest extends Action{

	@RequestMapping("to_upload")
	public String toUpload(){
		return "test/upload_test";
	}
	
	@RequestMapping("upload")
	public String upload(Model model){
		getValues().put("fname", getFiles()[0].getName());
		return "test/upload_test";
	}
	
}
