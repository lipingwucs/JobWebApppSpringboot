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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Category CRUD", description="Operations pertaining to Category in Recruitment Agency App ")
@RestController
public class CategoryController {

	@Autowired  
	CatService catService;

	// get category with certain Id
	@ApiOperation(value = "get category with certain Id")
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.GET)
	Category getCat(@PathVariable("jobCatId") int jobCatId) throws Exception {
		return catService.getCat(jobCatId);
	}

	// get all categories
	@ApiOperation(value = "get all categories")
	@RequestMapping(value = "/cats", method = RequestMethod.GET)
	Iterable<Category> getCats() {
		return catService.getCats();
	}

	// post a new category
	@ApiOperation(value = "create a new category")
	@RequestMapping(value = "/cats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	Category addCat(@RequestBody Category cat) throws Exception {
		catService.addCat(cat);
		return cat;
	}

	// update a category with jobCatId
	@ApiOperation(value = "update a category with jobCatId")
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	Category updateCat(@PathVariable("jobCatId") int jobCatId, @RequestBody Category cat) throws Exception {
		cat.setJobCatId(jobCatId);
		catService.updateCat(cat);
		return catService.getCat(jobCatId);
	}

	// delete a category with jobCatId
	@ApiOperation(value = "delete a category with jobCatId")
	@RequestMapping(value = "/cats/{jobCatId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deleteCat(@PathVariable("jobCatId") int jobCatId) throws Exception {
		catService.deleteCat(jobCatId);
	}
}