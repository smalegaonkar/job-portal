package com.Final.Project.POJO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class JobApplications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="APPLICATION_ID", unique=true, nullable=false)
	private int applicationID;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Candidate job_Seeker;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Job job;	
	
	

	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}


	public Candidate getJob_Seeker() {
		return job_Seeker;
	}
	public void setJob_Seeker(Candidate job_Seeker) {
		this.job_Seeker = job_Seeker;
	}


	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}
