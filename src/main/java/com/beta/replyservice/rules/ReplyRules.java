package com.beta.replyservice.rules;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.beta.replyservice.exception.ReplyServiceInvalidInputException;

/**
 * This class will contains all the rules 
 * 
 * Design a separate method for each new rule
 * 
 * Add a switch case in apply(string) method for new rule
 * 
 * **/

public class ReplyRules {

	static String reverse(String message) {

		return new StringBuilder(message).reverse().toString();
	}
	
	static String md5HashInHex(String message) {
	
		try {
            
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(message.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}

	public static String apply(String string) {
		
		String[] messages = string.split("-");
		
		if(messages.length < 2) {
			throw new ReplyServiceInvalidInputException();
		}
		
		String rules = messages[0];
		String message = messages[1];
		
		if(rules.length() > 2) {
			throw new ReplyServiceInvalidInputException();
		}
		
		/*
		 * Add switch cases for new rules
		 * */
		
		for(int i=0; i < rules.length(); i++) {
			
			switch(rules.charAt(i)) {
				case '1': message = reverse(message);
							break;
				case '2': message = md5HashInHex(message);
							break;
				default : throw new ReplyServiceInvalidInputException();
			}
		}
		
		return message;
		
	}
}
