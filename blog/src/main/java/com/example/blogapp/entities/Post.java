package com.example.blogapp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer postId;
	@Column(name="post_title", length=100, nullable=false)
private String title;
	@Column(name="post_content", length=10000)
private String content;
private String imageName;
private Date addedDate;
@ManyToOne
private User user;
@ManyToOne
@JoinColumn(name="category_id")
private Category category;
}
