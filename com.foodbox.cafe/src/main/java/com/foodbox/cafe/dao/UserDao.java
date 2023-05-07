package com.foodbox.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.cafe.POJO.User;

public interface UserDao extends JpaRepository<User, Integer> {
	

}
