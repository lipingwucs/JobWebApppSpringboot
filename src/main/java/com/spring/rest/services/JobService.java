/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */
package com.spring.rest.services;

import java.util.HashMap;
import java.util.Map;

//import org.hibernate.mapping.Map;  //not this map
import org.springframework.stereotype.Service;

import com.spring.rest.exception.DuplicateException;
import com.spring.rest.exception.NotFoundException;
import com.spring.rest.models.Job;


@Service
public class JobService {
	Map<Integer, Job> jobs = new HashMap<>();
	
	public void addJob(Job job) throws DuplicateException {
		if (jobs.containsKey(job.getJobId())) {
			throw new DuplicateException ("This job id already exists: " + job.getJobId());			
		} else {
			jobs.put(job.getJobId(),job);
		}
	}
	
	//get all the jobs
	public Iterable<Job> getJobs() {	
		System.out.println("get Jobs: "+jobs.values());
		return jobs.values();
		
	}

	// get job by id
	public Job getJob(int jobId) throws NotFoundException {
		if (jobs.containsKey(jobId)) {
			return jobs.get(jobId);
		} else {
			throw new NotFoundException  ("Job id not found:" +jobId);
		}		
	}
	
	// update job by id
	public void updateJob (Job job) throws NotFoundException {
		if(jobs.containsKey(job.getJobId())) {
			jobs.put(job.getJobId(), job);
		} else {
			throw new NotFoundException ("Job Id not found: "+ job.getJobId());
		}
	}
	
	// delete job by id
	public void deleteJob (int jobId) throws Exception {
		if(jobs.containsKey(jobId)) {
			jobs.remove(jobId);
		} else {
			throw new NotFoundException ("Job Id  not found: "+ jobId );
		}
	}

}
