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

import com.spring.rest.models.Category;
import com.spring.rest.services.CatService;


@RestController
public class CategoryController {

	@Autowired
	CatService catService;

	// get category with certain Id
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.GET)
	Category getCat(@PathVariable("jobCatId") int jobCatId) throws Exception {
		return catService.getCat(jobCatId);
	}

	// get all categories
	@RequestMapping(value = "/cats", method = RequestMethod.GET)
	Iterable<Category> getCats() {
		return catService.getCats();
	}

	// post a new category
	@RequestMapping(value = "/cats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	void addCat(@RequestBody Category cat) throws Exception {
		catService.addCat(cat);
	}

	// update a category with jobCatId
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	void updateCat(@PathVariable("jobCatId") int jobCatId, @RequestBody Category cat) throws Exception {
		cat.setJobCatId(jobCatId);
		catService.updateCat(cat);
	}

	// delete a category with jobCatId
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	void deleteCat(@PathVariable("jobCatId") int jobCatId) throws Exception {
		catService.deleteCat(jobCatId);
	}

}