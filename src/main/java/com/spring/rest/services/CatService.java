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
import com.spring.rest.models.Category;

@Service
public class CatService {
	Map<Integer, Category> cats = new HashMap<>();

	public void addCat(Category cat) throws Exception {
		if (cats.containsKey(cat.getJobCatId())) {
			throw new DuplicateException ("This category id already exists.");
		} else {
			cats.put(cat.getJobCatId(), cat);
		}
	}

	// get all the category
	public Iterable<Category> getCats() {
		System.out.println("get categories: " + cats.values());
		return cats.values();

	}

	// get category by id
	public Category getCat(int jobCatId) throws Exception {
		if (cats.containsKey(jobCatId)) {
			return cats.get(jobCatId);
		} else {
			throw new NotFoundException("job Cat Id id not found: "+ jobCatId);
		}
	}

	// update category by id
	public void updateCat(Category cat) throws Exception {
		if (cats.containsKey(cat.getJobCatId())) {
			cats.put(cat.getJobCatId(), cat);
		} else {
			throw new NotFoundException("Category Id not found:"+ cat.getJobCatId());
		}
	}

	// delete category by id
	public void deleteCat(int jobCatId) throws Exception {
		if (cats.containsKey(jobCatId)) {
			cats.remove(jobCatId);
		} else {
			throw new NotFoundException("job Cat Id Id not found: "+ jobCatId);
		}
	}

}