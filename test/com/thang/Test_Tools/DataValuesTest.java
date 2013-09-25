package com.thang.Test_Tools;

import org.apache.commons.codec.digest.DigestUtils;

import com.thang.tools.model.DataValues;

public class DataValuesTest {

	
	public static void main(String[] args) {
		DataValues d=new DataValues();
		d.put("id", "123");
		d.put("name", "admin");
		d.put("title", "管理员");
		
		System.out.println(DigestUtils.md5Hex("su"));
	}
	
}
