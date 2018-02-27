package com.manju.urlshortnerservice;

import java.util.Random;

public class RandomString {

	private static final String charList= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int randomStringLength = 7;
	
//	public static String generatedURL() {
//		return "http://localhost:8080/" + getRandomString();
//	}
	
	private static int getRandomNumber() {
		Random r = new Random();
		int randomNumber = 0;
		randomNumber = r.nextInt(charList.length()-1);
		return randomNumber;
	}
	
	public static String getRandomString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<randomStringLength; i++) {
			int number = getRandomNumber();
			char c = charList.charAt(number);
			sb.append(c);
		}
		return sb.toString();
	}
}
