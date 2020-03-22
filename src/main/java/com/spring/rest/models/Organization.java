/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */
package com.spring.rest.models;

import java.util.Date;

public class Organization {
	private int orgId;
	private String orgName;
	private String address;
	private String postalCode;
	private String phoneNo;
	private String email;
	private String website;
	public int getOrgId() {
		return orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public String getAddress() {
		return address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public String getWebsite() {
		return website;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public Organization(int orgId, String orgName, String address, String postalCode, String phoneNo,
			String email, String website) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNo = phoneNo;
		this.email = email;
		this.website = website;
	}
	
	public Organization() {
		super();
	}
	
	@Override
	public String toString() {
		return "OrganizationController [orgId=" + orgId + ", orgName=" + orgName + ", address=" + address
				+ ", postalCode=" + postalCode + ", phoneNo=" + phoneNo + ", email=" + email + ", website=" + website
				+ "]";
	}
	
}
