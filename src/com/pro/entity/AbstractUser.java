package com.pro.entity;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private int uid;
	private String uusername;
	private String upassword;
	private String urole;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** full constructor */
	public AbstractUser(String uusername, String upassword, String urole) {
		this.uusername = uusername;
		this.upassword = upassword;
		this.urole = urole;
	}

	// Property accessors

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUusername() {
		return this.uusername;
	}

	public void setUusername(String uusername) {
		this.uusername = uusername;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUrole() {
		return this.urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

}