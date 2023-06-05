package com.mmhernandez.relationships.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="licenses")
public class License {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="License number required")
	@Size(min=7, message="License number must be at least 7 characters")
	private String number;
	
	@NotNull(message="Expiration date required")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	
	@NotNull(message="State required")
	@Size(min=2, message="State must be at least 2 characters")
	private String state;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	
//	CONSTRUCTORS
	public License() {}
	public License(String number, Date expirationDate, String state) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
	}
	
}
