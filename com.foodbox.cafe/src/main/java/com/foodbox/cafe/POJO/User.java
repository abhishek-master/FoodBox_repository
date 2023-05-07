package com.foodbox.cafe.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionId = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name="contactNumber")
	private String contactNumber ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name="password")
	private String password ;
	
	@Column(name="status")
	private String status ;
	
	@Column(name="role")
	private String role ;
	
}