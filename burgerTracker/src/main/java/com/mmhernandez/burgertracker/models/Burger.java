package com.mmhernandez.burgertracker.models;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burger")
public class Burger {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@NotNull(message="Name required")
	@Size(min=2, max=255, message="Name must be at least 2 characters")
	public String name;
	
	@NotNull(message="Restaurant name required")
	@Size(min=2, max=255, message="Restaurant name must be at least 2 characters")
	public String restaurantName;
	
	@NotNull(message="Rating required")
	@Size(min=1, max=5, message="Rating must be between 1-5")
	public Integer rating;
	
	@NotEmpty(message="Notes required")
	@Min(value=10, message="Notes must be at least 10 characters")
	@Max(value=255, message="Notes loo long")
	public String notes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy=MM-dd")
	public Date createdAt;
	
	@DateTimeFormat(pattern="yyyy=MM-dd")
	public Date updatedAt;
	
	
//	CONSTRUCTOR
	public Burger() { }
	public Burger(String name, String restaurantName, Integer rating, String notes) {
		this.name = name;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}
	
	
//	GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
