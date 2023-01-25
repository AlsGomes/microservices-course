package br.com.agdev.mscourse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppEncoder {

	public static void main(String[] args) {
		var password = "123456";
		var encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(password));
	}
}
