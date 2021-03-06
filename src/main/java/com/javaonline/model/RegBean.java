package com.javaonline.model;
 
import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name="tb_user")
public class RegBean implements Serializable {
 
	@Id
	@GeneratedValue
	@Column(name="regId")
	// private String regId="";
	private Long regId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="emailId")
	private String emailId;
	 
	@Temporal(TemporalType.DATE)
	@Column (name="createdOn")	
	// private Date createdOn;
	private Calendar createdOn;
 
 	// public Date getCreatedOn() {
	public Calendar getCreatedOn() {
		// return new Date();
		return createdOn;
	}
	
	// public void setCreatedOn(Date createdOn) {
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	public Long getRegId() {
		return regId;
	}
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
 
}
