package com.pro.entity;

import java.sql.Timestamp;

/**
 * AbstractAlarm entity provides the base persistence definition of the Alarm
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAlarm implements java.io.Serializable {

	// Fields

	private int aid;
	private Timestamp astime;
	private Timestamp aetime;
	private String alocation;
	private String adetail;
	private String astatues;
	private String atype;
	private int aisdeal;
	// Constructors

	public int getAisdeal() {
		return aisdeal;
	}

	public void setAisdeal(int aisdeal) {
		this.aisdeal = aisdeal;
	}

	/** default constructor */
	public AbstractAlarm() {
	}

	/** full constructor */
	public AbstractAlarm(Timestamp astime, Timestamp aetime, String alocation,
			String adetail, String astatues, String atype,int aisdeal) {
		this.astime = astime;
		this.aetime = aetime;
		this.alocation = alocation;
		this.adetail = adetail;
		this.astatues = astatues;
		this.atype = atype;
		this.aisdeal = aisdeal;
	}

	// Property accessors

	public int getAid() {
		return this.aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Timestamp getAstime() {
		return this.astime;
	}

	public void setAstime(Timestamp astime) {
		this.astime = astime;
	}

	public Timestamp getAetime() {
		return this.aetime;
	}

	public void setAetime(Timestamp aetime) {
		this.aetime = aetime;
	}

	public String getAlocation() {
		return this.alocation;
	}

	public void setAlocation(String alocation) {
		this.alocation = alocation;
	}

	public String getAdetail() {
		return this.adetail;
	}

	public void setAdetail(String adetail) {
		this.adetail = adetail;
	}

	public String getAstatues() {
		return this.astatues;
	}

	public void setAstatues(String astatues) {
		this.astatues = astatues;
	}

	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

}