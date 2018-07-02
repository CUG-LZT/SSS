package com.pro.entity;

import java.sql.Timestamp;

/**
 * Alarm entity. @author MyEclipse Persistence Tools
 */
public class Alarm extends AbstractAlarm implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Alarm() {
	}

	/** full constructor */
	public Alarm(Timestamp astime, Timestamp aetime, String alocation,String adetail, String astatues, String atype,int aisdedal) {
		super(astime, aetime, alocation, adetail, astatues, atype, aisdedal);
	}

}
