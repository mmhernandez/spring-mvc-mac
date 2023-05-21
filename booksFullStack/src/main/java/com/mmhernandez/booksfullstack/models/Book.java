package com.mmhernandez.booksfullstack.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
	@NotNull(message="Title required") @Size(min=2, max=255, message="Title must be at least 2 characters") private String title;
	@NotNull(message="Description required") @Size(min=10, max=255, message="Description must be between 10-255 characters") private String description;
	@NotNull(message="Language required") @Size(min=2, max=255, message="Language must be at least 2 characters")private String language;
	@NotNull(message="Number of pages required") @Min(value=50, message="Must have at least 50 pages") private Integer numberOfPages;
	@Column(updatable=false) @DateTimeFormat(pattern="yyyy-MM-dd") private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd") private Date updatedAt;
	
//	CONSTRUCTORS
	public Book() { };
	
	public Book(String title, String description, String language, Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}
	
//	GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
//	OTHER METHODS
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
