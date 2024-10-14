package com.mycompany.gethired.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.gethired.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	private String title;
	private String feedback;
	private Float rating;
	
	@JsonIgnore
	@ManyToOne
	private Company company;
	
	
	public Review() {
		super();
	}
	
	public Review(Long reviewId, String title, String feedback, Float rating) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.feedback = feedback;
		this.rating = rating;
	}
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public Long getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public Float getRating() {
		return rating;
	}
	
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
}
