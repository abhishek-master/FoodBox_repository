package com.foodbox.cafe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils { //in utils class we keep generic methods which we need everywhere/many times  
						 //say we need to need a method to generate

	private CafeUtils() {}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		return new ResponseEntity<String> ("{\"message\":\""+ responseMessage +"\"}", httpStatus) ; 
	}
	
}
