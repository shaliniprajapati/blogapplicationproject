package com.example.blogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.entities.Category;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.payloads.CategoryDdo;
import com.example.blogapp.repositories.CategoryRepo;
import com.example.blogapp.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDdo createCategory(CategoryDdo categoryDdo) {
		Category category=modelMapper.map(categoryDdo, Category.class);
		Category savedCategory=categoryRepo.save(category);
		CategoryDdo savedCategoryDdo=modelMapper.map(savedCategory, CategoryDdo.class);
		
		return savedCategoryDdo;
	}

	@Override
	public CategoryDdo updateCategory(CategoryDdo categoryDdo, Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category ID",categoryId));
		category.setCategoryTitle(categoryDdo.getCategoryTitle());
		category.setCategoryDescription(categoryDdo.getCategoryDescription());
		Category updatedCategory=categoryRepo.save(category);
		CategoryDdo updatedCategoryDdo=modelMapper.map(updatedCategory, CategoryDdo.class);
		return updatedCategoryDdo;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category ID",categoryId));
		categoryRepo.delete(category);
		
	}

	@Override
	public CategoryDdo getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category ID",categoryId));	
		CategoryDdo categoryDdo=modelMapper.map(category, CategoryDdo.class);
		return categoryDdo;
	}

	@Override
	public List<CategoryDdo> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories= this.categoryRepo.findAll();
		List<CategoryDdo> categoryDdo=categories.stream().map(e->modelMapper.map(e, CategoryDdo.class)).collect(Collectors.toList());
		return categoryDdo;
	}

}
