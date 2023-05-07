package com.foodbox.cafe.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.cafe.Rest.UserRest;
import com.foodbox.cafe.service.UserService;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	UserService userService ; 
	
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		try {
			return userService.signUp(requestMap) ;
		}catch(Exception ex) {
			ex.printStackTrace();			
		}
		return new ResponseEntity<String> ("{\"message\":\"Something wentWrong\"}", HttpStatus.INTERNAL_SERVER_ERROR) ; 
		
		
	}

}
