/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */
package com.spring.rest.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.rest.exception.DuplicateException;
import com.spring.rest.exception.NotFoundException;
import com.spring.rest.models.Organization;

@Service
public class OrgService {
	Map<Integer, Organization> orgs = new HashMap<>();
	
	//add an organization
	public void addOrg(Organization org) throws Exception {
		if (orgs.containsKey(org.getOrgId())) {
			throw new DuplicateException ("This job id already exists.");			
		} else {
			orgs.put(org.getOrgId(),org);
		}
	}
	
	//get all the organizations
	public Iterable<Organization> getOrgs() {	
		System.out.println("get Organizations: "+orgs.values());
		return orgs.values();
		
	}

	// get organization by id
	public Organization getOrg(int orgId) throws Exception {
		if (orgs.containsKey(orgId)) {
			return orgs.get(orgId);
		} else {
			throw new NotFoundException ("organization id not found");
		}		
	}
	
	// update Organization by id
	public void updateOrg (Organization org) throws Exception {
		if(orgs.containsKey(org.getOrgId())) {
			orgs.put(org.getOrgId(), org);
		} else {
			throw new NotFoundException ("Organization Id not found");
		}
	}
	
	// delete Organization by id
	public void deleteJob (int orgId) throws Exception {
		if(orgs.containsKey(orgId)) {
			orgs.remove(orgId);
		} else {
			throw new NotFoundException ("organization Id  not found");
		}
	}	
	

}