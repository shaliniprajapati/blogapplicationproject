package com.example.blogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.CategoryDdo;
import com.example.blogapp.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
	public ResponseEntity<CategoryDdo> createCategory(@RequestBody CategoryDdo categoryDdo)
	{
		CategoryDdo categorycreated=categoryService.createCategory(categoryDdo);
		return new ResponseEntity<>(categorycreated, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDdo> updateCategory(@RequestBody CategoryDdo categoryDdo, @PathVariable("id") Integer categoryid)
	{
		CategoryDdo categoryupdate=categoryService.updateCategory(categoryDdo, categoryid);
		return new ResponseEntity<>(categoryupdate, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted",true), HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDdo> getCategorybyId(@PathVariable("id") Integer categoryId)
	{
		CategoryDdo categoryDdo=categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDdo>(categoryDdo, HttpStatus.OK);
	}
	@GetMapping("/")
	
		public ResponseEntity<List<CategoryDdo>> getCategories(){
		
		return ResponseEntity.ok(categoryService.getCategories());
		}
	}


