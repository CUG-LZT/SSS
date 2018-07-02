package com.pro.entity;

/**
 * AbstractReport entity provides the base persistence definition of the Report
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractReport implements java.io.Serializable {

	// Fields

	private int rid;
	private int rroom;
	private String rtype;
	private String rdetail;
	private Boolean risdeal;

	// Constructors

	/** default constructor */
	public AbstractReport() {
	}

	/** full constructor */
	public AbstractReport(int rroom, String rtype, String rdetail,
			Boolean risdeal) {
		this.rroom = rroom;
		this.rtype = rtype;
		this.rdetail = rdetail;
		this.risdeal = risdeal;
	}

	// Property accessors

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRroom() {
		return this.rroom;
	}

	public void setRroom(int rroom) {
		this.rroom = rroom;
	}

	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getRdetail() {
		return this.rdetail;
	}

	public void setRdetail(String rdetail) {
		this.rdetail = rdetail;
	}

	public Boolean getRisdeal() {
		return this.risdeal;
	}

	public void setRisdeal(Boolean risdeal) {
		this.risdeal = risdeal;
	}

}