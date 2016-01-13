package com.Final.Project.POJO;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="USER_ACCOUNT")
public class User_Account
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USERACCOUNT_ID", unique=true, nullable=false)
	private int UserAccountID;
	
	@Column(name = "EMAIL_ID", length=100)
	private String emailID;
	
	@Column(name = "PASSWORD", nullable=false, length=100)
	private String password;
	
	@Column(name="ROLE", nullable=false, length=50)
	private String role;
	
	
	public int getUserAccountID() {
		return UserAccountID;
	}

	public void setUserAccountID(int userAccountID) {
		UserAccountID = userAccountID;
	}
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
