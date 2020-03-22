/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */

package com.spring.rest.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Job {	
	private int jobId;
	private String jobCode;
	private String jobName;
	private String jobDesc;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pubDate;
	private int numVacancy;
	private Organization organization;
	private Category category;
	
	//getters and setters
	public int getJobId() {
		return jobId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public String getJobName() {
		return jobName;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public int getNumVacancy() {
		return numVacancy;
	}
	public Organization getOrganization() {
		return organization;
	}
	public Category getCategory() {
		return category;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public void setNumVacancy(int numVacancy) {
		this.numVacancy = numVacancy;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	//constructor with fields
	public Job(int jobId, String jobCode, String jobName, String jobDesc, Date pubDate, int numVacancy,
			Organization organization, Category category) {
		super();
		System.out.println("come to this with all fields "+pubDate);
		this.jobId = jobId;
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.pubDate = pubDate;
		this.numVacancy = numVacancy;
		this.organization = organization;
		this.category = category;
	}
	
	//constructor with fields
		public Job(int jobId, String jobCode, String jobName, String jobDesc, Date pubDate, int numVacancy
				) {			
			super();
			System.out.println("no convert string to date: "+pubDate);
			this.jobId = jobId;
			this.jobCode = jobCode;
			this.jobName = jobName;
			this.jobDesc = jobDesc;
			this.pubDate = pubDate;
			this.numVacancy = numVacancy;
			this.organization = null;
			this.category = null;
		}
	
		//constructor with fields
		public Job(int jobId, String jobCode, String jobName, String jobDesc, String pubDate, int numVacancy
				) {
			super();			
			System.out.println("come to this convert string to date: "+pubDate);
			this.jobId = jobId;
			this.jobCode = jobCode;
			this.jobName = jobName;
			this.jobDesc = jobDesc;
			Date startDate= new Date(0) ;
			try {
				startDate = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
			} catch (ParseException e) {			
				e.printStackTrace();
			} 
			this.pubDate = startDate;
			this.numVacancy = numVacancy;
			this.organization = null;
			this.category = null;
		}
	
	//constructor without fields
	public Job() {
		super();
	}
	
	//toString()
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobCode=" + jobCode + ", jobName=" + jobName + ", jobDesc=" + jobDesc
				+ ", pubDate=" + pubDate + ", numVacancy=" + numVacancy + ", organization=" + organization
				+ ", category=" + category + "]";
	}
	
	
	
	
	
	
	
	
	

}
