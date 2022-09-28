package com.example.blogapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blogapp.payloads.CategoryDdo;
@Service
public interface CategoryService {
//create
	public CategoryDdo createCategory(CategoryDdo categoryDdo);
	
//update
	public CategoryDdo updateCategory(CategoryDdo categoryDdo, Integer categoryId);
//delete
	public void deleteCategory(Integer categoryId);
//get
	public CategoryDdo getCategory (Integer categoryId);
//getall
	List<CategoryDdo> getCategories();
}
