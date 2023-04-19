package com.Spring.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordUtils {
	
	public static String generateRandomPassword() {
	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	String password = RandomStringUtils.random( 6, characters );
	System.out.println( password );
	return password;
	}
}
