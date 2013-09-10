package com.thang.Test_Tools;

import com.thang.entity.system.Role;
import com.thang.tools.model.DataValues;

public class DataValuesTest {

	
	public static void main(String[] args) {
		DataValues d=new DataValues();
		d.put("id", "123");
		d.put("name", "admin");
		d.put("title", "管理员");
		Role r=d.covertToBean(Role.class);
		System.out.println(r.getId());
		System.out.println(r.getName());
		System.out.println(r.getTitle());
	}
	
}
