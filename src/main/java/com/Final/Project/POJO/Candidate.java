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
@Table(name = "JOB_SEEKER")
public class Candidate 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="JOBSEEKER_ID", unique=true, nullable=false)
	private int jobSeekerID;

	@Column(name = "FIRST_NAME", nullable=false, length=100)
	private String first_name;
	
	@Column(name = "LAST_NAME", nullable=false, length=100)
	private String last_name;
	
	@Column(name = "CONTACT_NUMBER", nullable=false)
	private String contact_number;
	
	@Column(name = "BIRTH_DATE", nullable=false)
	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	
	@Column(name = "LINKEDIN_URL", unique=true, nullable=false, length=200)
	private String linkedInUrl;
	
	@Column(name = "DEGREE", nullable=false, length=100)
	private String degree;
	
	@Column(name = "MAJOR", nullable=false, length=100)
	private String major;
	
	@Column(name = "WORK_EXPERIENCE", nullable=false)
	private int work_experience;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	private User_Account user_Account;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="job_Seeker", cascade=CascadeType.ALL)
	private List<JobApplications> jobApplicationList;
	
	
	public String getFirst_name() 
	{
		return first_name;
	}
	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
	}
	
	public String getLast_name() 
	{
		return last_name;
	}
	public void setLast_name(String last_name) 
	{
		this.last_name = last_name;
	}
	public String getContact_number() 
	{
		return contact_number;
	}
	public void setContact_number(String contact_number) 
	{
		this.contact_number = contact_number;
	}
	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getLinkedInUrl() 
	{
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) 
	{
		this.linkedInUrl = linkedInUrl;
	}
	public String getDegree()
	{
		return degree;
	}
	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major) 
	{
		this.major = major;
	}
	public int getWork_experience() 
	{
		return work_experience;
	}
	public void setWork_experience(int work_experience)
	{
		this.work_experience = work_experience;
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
	
	public int getJobSeekerID() {
		return jobSeekerID;
	}

	public void setJobSeekerID(int jobSeekerID) {
		this.jobSeekerID = jobSeekerID;
	}

	
}
