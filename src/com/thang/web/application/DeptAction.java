package com.thang.web.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thang.service.application.DeptManager;
import com.thang.tools.model.Action;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;
import com.thang.tools.model.Tree;

@Controller
@RequestMapping("application/dept")
public class DeptAction extends Action{

	@Autowired
	private DeptManager deptManager;
	
	@RequestMapping("list")
	public String list(){
		return "application/dept/list";
	}
	
	@RequestMapping("tree")
	public void tree(){
		ActionValues values=getValues();
		
		List<ResultValues> results=deptManager.query(values);
		
		List<Tree> trees=new ArrayList<Tree>();
		Tree tree=null;
		for(ResultValues result:results){
			tree=new Tree(result.getInt("id"),result.getStr("title"));
			trees.add(tree);
		}
		print(trees);
	}
	
}
