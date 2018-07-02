package com.pro.entity;

/**
 * Report entity. @author MyEclipse Persistence Tools
 */
public class Report extends AbstractReport implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Report() {
	}

	/** full constructor */
	public Report(int rroom, String rtype, String rdetail, Boolean risdeal) {
		super(rroom, rtype, rdetail, risdeal);
	}

}
