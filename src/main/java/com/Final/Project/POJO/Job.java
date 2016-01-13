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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="JOB")
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="JOB_ID", unique=true, nullable=false)
	private int jobID;
	
	@Column(name="JOB_TITLE", nullable=false, length=100)
	private String jobTitle;
	
	@Column(name="JOB_DESCRIPTION", nullable=false, length=1000)
	private String jobDescription;
	
	@Column(name="JOB_REQUIREMENTS", nullable=false, length=1000)
	private String jobRequirements;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private HR hr;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="job", cascade=CascadeType.ALL)
	private List<JobApplications> jobApplicationList;
	
	//************************
	/*@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Organization organization;*/
	
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public String getJobRequirements() {
		return jobRequirements;
	}
	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}
	
	public HR getHr() {
		return hr;
	}
	public void setHr(HR hr) {
		this.hr = hr;
	}
	
	public List<JobApplications> getJobApplicationList() {
		return jobApplicationList;
	}
	public void setJobApplicationList(List<JobApplications> jobApplicationList) {
		this.jobApplicationList = jobApplicationList;
	}
	/*public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}*/
}
