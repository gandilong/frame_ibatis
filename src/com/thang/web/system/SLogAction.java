package com.thang.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.system.SLogManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;

@Controller
@RequestMapping("system/slog")
public class SLogAction extends Action{

	@Autowired
	private SLogManager slogManager;
	
	@RequestMapping("list")
	public String list(){
		return "system/slog/list";
	}
	
	@RequestMapping("listData")
	public void listData(){
		ActionValues values=getValues();
		List<DataValues> slogs=slogManager.query(values);
		values.put("total", values.getInt("total"));
		values.put("rows", slogs);
		printJSON(values);
	}
	
}
