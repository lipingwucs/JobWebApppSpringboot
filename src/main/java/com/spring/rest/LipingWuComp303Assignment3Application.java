package com.spring.rest;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.rest.models.Category;
import com.spring.rest.models.Job;
import com.spring.rest.models.Organization;
import com.spring.rest.services.CatService;
import com.spring.rest.services.JobService;
import com.spring.rest.services.OrgService;



/*COMP303_Assignment3
 *Liping Wu 300958061
 *3-9-2020
 * */

@SpringBootApplication
public class LipingWuComp303Assignment3Application implements WebMvcConfigurer  {

	public static void main(String[] args) {
		SpringApplication.run(LipingWuComp303Assignment3Application.class, args);
		System.out.println("Spring boot REST API for Job is start here:  http://localhost:8081/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public ApplicationRunner orgsInitializer(OrgService orgService) {
		return args -> {			
			orgService.addOrg(new Organization(1, "TD Bank", "320 Front St W", "N1V3S8", "416-100-8888", "hr@td.com", "http://www.td.com"));
			orgService.addOrg(new Organization(2, "BMO", "88 King St ", "B1V5Z9", "416-200-8888", "hr@bmo.com", "http://www.bmo.com"));
			orgService.addOrg(new Organization(3, "RBC Bank", "86 Queen St ", "N2V3S6", "416-300-8888", "hr@rbc.com", "http://www.rbc.com"));
									
		};
	}
	
	@Bean
	public ApplicationRunner jobsInitializer(JobService jobService) {
		return args -> {			
			jobService.addJob(new Job(1, "j0001", "Branch Manager", "Manage a 100 person branch", new Date(), 3));
			jobService.addJob(new Job(2, "j0002", "VP", "Manage the cloud software engineer department", new Date(), 1));
			jobService.addJob(new Job(3, "j0003", "Financial product Manager", "provide service for our mutual fund", new Date(), 10));
			jobService.addJob(new Job(4, "j0003", "Financial product Manager", "provide service for our mutual fund", new Date(), 10));
			jobService.addJob(new Job(5, "j0002", "Software Developer", "IT cloud software development and support", new Date(), 5));
										
		};
	}
	
	@Bean
	public ApplicationRunner catsInitializer(CatService catService) {
		return args -> {			
			catService.addCat(new Category(1, "c0001", "Management", "Management position"));
			catService.addCat(new Category(2, "c0002", "Market", "Marketing, sales person position"));
			catService.addCat(new Category(3, "c0003", "Technical", "professional technical position"));						
		};
	}

}
