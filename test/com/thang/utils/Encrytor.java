package com.thang.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Encrytor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(DigestUtils.md5Hex("su"));
	}

}
