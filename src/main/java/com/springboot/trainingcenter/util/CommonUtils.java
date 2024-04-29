package com.springboot.trainingcenter.util;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

	public CommonUtils() {}
	
	public static boolean isValidCenterCode(String centerCode) {
		String regex="(?:[a-zA-Z]){6}(?:\\d.*){6}";
		return centerCode.matches(regex);
	}
	
	public static boolean isValidPhoneNum(String num) {
		String phoneRegex="^\\d{10}$";
		return num.matches(phoneRegex);
	}
	
	public static boolean isValidEmail(String email) {
		String emailRegex="^(.+)@(.+)$";
		
		return email.matches(emailRegex);
	}
	

	
}
