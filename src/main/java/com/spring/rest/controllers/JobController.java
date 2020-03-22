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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.models.Job;
import com.spring.rest.services.JobService;

@RestController
public class JobController {
	@Autowired
	JobService jobService;	
	
	//get job with certain Id
	@RequestMapping(value="/jobs/{jobId}", method = RequestMethod.GET)
	Job getJob(@PathVariable("jobId") int jobId) throws Exception {
		return jobService.getJob(jobId);		
	}
	
	//get all jobs
	@RequestMapping(value="/jobs", method = RequestMethod.GET)
	Iterable<Job> getJobs() {
		return jobService.getJobs();		
	}
	
	// post a new job
	@RequestMapping(value = "/jobs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus (value = HttpStatus.OK)
	void addJob (@RequestBody Job job) throws Exception {
		jobService.addJob(job);
	}
	//update a job with jobId
	@RequestMapping(value ="/jobs/{jobId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	void updateJob(@PathVariable("jobId") int jobId, @RequestBody Job job) throws Exception{
		job.setJobId(jobId);
		jobService.updateJob(job);		
	}
	
	//delete a job with jobId
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.DELETE)
	@ResponseStatus (value = HttpStatus.OK)
	void deleteJob(@PathVariable("jobId") int jobId) throws Exception {
        jobService.deleteJob(jobId);
	}

	
	
	

}
