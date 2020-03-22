/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */

package com.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.spring.rest.models.Organization;
import com.spring.rest.services.OrgService;

@RestController
public class OrganizationController {

	@Autowired
	OrgService orgService;

	// get organization with certain Id
	@RequestMapping(value = "/orgs/{orgId}", method = RequestMethod.GET)
	Organization getOrg(@PathVariable("orgId") int orgId) throws Exception {
		return orgService.getOrg(orgId);
	}

	// get all orgs
	@RequestMapping(value = "/orgs", method = RequestMethod.GET)
	Iterable<Organization> getOrgs() {
		return orgService.getOrgs();
	}

	// post a new org
	@RequestMapping(value = "/orgs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	Organization addOrg(@RequestBody Organization org) throws Exception {
		orgService.addOrg(org);
		return org;
	}

	// updatea org with orgId
	@RequestMapping(value = "/orgs/{orgId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	Organization updateOrg(@PathVariable("orgId") int orgId, @RequestBody Organization org) throws Exception {
		org.setOrgId(orgId);
		orgService.updateOrg(org);
		return orgService.getOrg(orgId);
	}

	// delete a org with orgId
	@RequestMapping(value = "/orgs/{orgId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deleteOrg(@PathVariable("orgId") int orgId) throws Exception {
		orgService.deleteJob(orgId);
	}

}
