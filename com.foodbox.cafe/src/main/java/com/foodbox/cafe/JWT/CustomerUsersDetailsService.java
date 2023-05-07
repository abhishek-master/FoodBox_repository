package com.foodbox.cafe.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.foodbox.cafe.dao.UserDao;
import com.foodbox.cafe.serviceImpl.UserServiceImpl;

@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao ;
	
	private com.foodbox.cafe.POJO.User userDetail ;
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}", username);
		userDetail = userDao.findByEmailId(username) ;
		if(!Objects.isNull(userDetail)) {
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>()) ;
		}
		else {
			throw new UsernameNotFoundException("User not found") ;
		}
	}
	
	public com.foodbox.cafe.POJO.User getUserDetails(){
		return userDetail ;
	}
}
