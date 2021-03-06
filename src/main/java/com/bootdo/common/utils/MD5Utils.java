package com.bootdo.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	//干扰数据 盐 防破解
	private static final String SALT = "1qazxsw2";
	//散列算法类型为MD5
	private static final String ALGORITH_NAME = "md5";
	//hash的次数
	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static void main(String[] args) {
		//27bd386e70f280e24c2f4f2a549b82cf
		//System.out.println(MD5Utils.encrypt("admin", "1"));
	}

}
