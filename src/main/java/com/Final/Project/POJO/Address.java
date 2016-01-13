package com.Final.Project.POJO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID", unique=true, nullable=false)
	private int addressID;
	
	@Column(name = "STREET", nullable=false, length=200)
	private String street;
	
	@Column(name = "CITY", nullable=false, length=50)
	private String city;
	
	@Column(name = "STATE", nullable=false, length=500)
	private String state;
	
	@Column(name = "ZIPCODE", nullable=false)
	private int zipcode;
	
	@Column(name = "COUNTRY", nullable=false, length=50)
	private String country;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="address", cascade=CascadeType.ALL)
	private Set<Candidate> job_SeekerList = new HashSet<Candidate>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="address", cascade=CascadeType.ALL)
	private Set<HR> hrList = new HashSet<HR>();

	
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Set<Candidate> getJob_SeekerList() {
		return job_SeekerList;
	}

	public void setJob_SeekerList(Set<Candidate> job_SeekerList) {
		this.job_SeekerList = job_SeekerList;
	}
	
	public Set<HR> getHrList() {
		return hrList;
	}

	public void setHrList(Set<HR> hrList) {
		this.hrList = hrList;
	}
}
