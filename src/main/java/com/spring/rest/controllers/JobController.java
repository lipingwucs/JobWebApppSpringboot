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

import com.spring.rest.models.Job;
import com.spring.rest.services.JobService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="JOB CRUD", description="Operations pertaining to JOB in Recruitment Agency App ")
@RestController
public class JobController {
	@Autowired
	JobService jobService;	
	
	//get job with certain Id
	@ApiOperation(value = "get job with certain Id")
	@RequestMapping(value="/jobs/{jobId}", method = RequestMethod.GET)
	Job getJob(@PathVariable("jobId") int jobId) throws Exception {
		return jobService.getJob(jobId);		
	}
	
	//get all jobs
	@ApiOperation(value = "get all jobs")
	@RequestMapping(value="/jobs", method = RequestMethod.GET)
	Iterable<Job> getJobs() {
		return jobService.getJobs();		
	}
	
	// post a new job
	@ApiOperation(value = "create a new job")
	@RequestMapping(value = "/jobs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus (value = HttpStatus.CREATED)
	Job addJob (@RequestBody Job job) throws Exception {
		try {
			System.out.println("got a request to add a job: " + job);			
			jobService.addJob(job);
			return job;
		} catch (Exception e) {
			System.out.println("got a exception when add a job: " + e);
			throw e;
		}
	}
	//update a job with jobId
	@ApiOperation(value = "update a job with jobId")
	@RequestMapping(value ="/jobs/{jobId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	Job updateJob(@PathVariable("jobId") int jobId, @RequestBody Job job) throws Exception{
		job.setJobId(jobId);
		jobService.updateJob(job);
		return jobService.getJob(jobId);
	}
	
	//delete a job with jobId
	@ApiOperation(value = "delete a job with jobId")
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.DELETE)
	@ResponseStatus (value = HttpStatus.NO_CONTENT)
	void deleteJob(@PathVariable("jobId") int jobId) throws Exception {
        jobService.deleteJob(jobId);
	}

}
