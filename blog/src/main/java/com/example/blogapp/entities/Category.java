package com.example.blogapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cateories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer categoryId;
	@Column(name="title")
private String categoryTitle;
	@Column(name="description")
private String categoryDescription;
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
private List<Post> posts=new ArrayList<>();
public Category() {
	super();
}
public Category(Integer categoryId, String categoryTitle, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDescription = categoryDescription;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryTitle() {
	return categoryTitle;
}
public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

}
