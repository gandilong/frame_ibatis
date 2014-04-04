package com.thang.service.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Service
public class PersonManager extends BaseDao{

	public List<ResultValues> query(ActionValues values){
		return list("application.person.query", values);
	}
	
}
