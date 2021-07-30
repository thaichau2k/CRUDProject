package com.rikkei.crud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "abc";
		System.out.println(encoder.encode(rawPassword));
	}

}
