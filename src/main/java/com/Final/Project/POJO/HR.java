package com.Final.Project.POJO;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Hiring_Manager")
public class HR 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="HR_ID", unique=true, nullable=false)
	private int HrID;
	
	@Column(name="FIRST_NAME", nullable=false, length=100)
	private String firstname;
	
	@Column(name="LAST_NAME", nullable=false, length=100)
	private String lastname;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private User_Account user_Account;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Organization company;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hr", cascade=CascadeType.ALL)
	private List<Job> jobList;

	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public User_Account getUser_Account() {
		return user_Account;
	}
	public void setUser_Account(User_Account user_Account) {
		this.user_Account = user_Account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Organization getCompany() {
		return company;
	}
	public void setCompany(Organization company) {
		this.company = company;
	}

	public int getHrID() {
		return HrID;
	}


	public void setHrID(int hrID) {
		HrID = hrID;
	}

	public List<Job> getJobList() {
		return jobList;
	}


	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
	
}
