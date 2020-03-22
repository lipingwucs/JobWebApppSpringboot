/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */
package com.spring.rest.models;

import java.util.Date;

public class Category {
	private int jobCatId;
	private String catCode;
	private String catName;
	private String catDesc;
	
	public int getJobCatId() {
		return jobCatId;
	}
	public String getCatCode() {
		return catCode;
	}
	public String getCatName() {
		return catName;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setJobCatId(int jobCatId) {
		this.jobCatId = jobCatId;
	}
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	public Category(int jobCatId, String catCode, String catName, String catDesc) {
		super();
		this.jobCatId = jobCatId;
		this.catCode = catCode;
		this.catName = catName;
		this.catDesc = catDesc;
	}
	
	public Category() {
		super();
	}
	
	@Override
	public String toString() {
		return "Category [jobCatId=" + jobCatId + ", catCode=" + catCode + ", catName=" + catName + ", catDesc="
				+ catDesc + "]";
	}
	
	
	
	
	

}
