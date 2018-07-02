package com.pro.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uusername, String upassword, String urole) {
		super(uusername, upassword, urole);
	}

}
