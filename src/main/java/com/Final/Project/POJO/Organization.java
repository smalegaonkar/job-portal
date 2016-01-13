package com.Final.Project.POJO;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Organization 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COMPANY_ID", unique=true, nullable=false)
	private int companyID;
	
	@Column(name="COMPANY_NAME", nullable=false, length=100)
	private String companyName;
	
	//********************************
	/*@OneToMany(fetch=FetchType.LAZY, mappedBy="organization", cascade=CascadeType.ALL)
	private List<Job> jobList;*/
	
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/*public List<Job> getJobList() {
		return jobList;
	}
	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}*/		
}