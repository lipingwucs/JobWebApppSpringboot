/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */
package com.spring.rest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.rest.models.Job;
import com.spring.rest.services.JobService;

@Controller
public class JobWebController {
	
	private final JobService jobService;

	public JobWebController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("/jobs.html")
	public String listJobs(Model model) {
		model.addAttribute("jobList", jobService.getJobs());
		return "jobs/jobList";
	}

	@GetMapping(value = "/jobs_details.html", params = "jobId")
	public String getJob(@RequestParam("jobId") int jobId, Model model) throws Exception {	
		model.addAttribute("job", jobService.getJob(jobId));
		return "jobs/jobDetails";
	}
	
	@GetMapping("/jobs_add.html")
	public String createJob(Model model) {
		model.addAttribute("job", new Job());
		return "jobs/jobAdd";
	}
	
	@PostMapping("/jobs_add.html")
	public String createJobPost(@ModelAttribute Job job) throws Exception {
		 jobService.addJob(job);		
		 return "redirect:/jobs.html";
	}
	
	@GetMapping(value = "/jobs_update.html", params = "jobId")
	public String updateJob(@RequestParam("jobId") int jobId, Model model) throws Exception {	
		model.addAttribute("job", jobService.getJob(jobId));
		return "jobs/jobUpdate";
	}

}