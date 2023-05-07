package com.foodbox.cafe.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodbox.cafe.POJO.User;
import com.foodbox.cafe.constants.CafeConstants;
import com.foodbox.cafe.dao.UserDao;
import com.foodbox.cafe.service.UserService;
import com.foodbox.cafe.utils.CafeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao ;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("Inside Signup {}", requestMap) ;
		try {
		if(validateSignUpMap(requestMap)) {
			User user = userDao.findByEmailId(requestMap.get("email")) ; 
			if(Objects.isNull(user)) {
				userDao.save(getUserFromMap(requestMap)) ;
				return CafeUtils.getResponseEntity("Successfully Registered ", HttpStatus.OK) ;
			}
			else {
				return CafeUtils.getResponseEntity("Email Already Exists", HttpStatus.BAD_REQUEST) ;
			}
		}else {
			return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST) ;
		}}catch(Exception ex) {
			ex.printStackTrace() ;
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR ) ;
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		return requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email") && requestMap.containsKey("password") ;
	}
	
	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User() ;
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole("user");
		return user ;
	}

}
