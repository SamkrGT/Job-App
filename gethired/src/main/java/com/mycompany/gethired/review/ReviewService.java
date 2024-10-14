package com.mycompany.gethired.review;

import java.util.List;

public interface ReviewService{
	boolean addReview(Long companyId, Review review);
	List<Review> findAllReviews(Long companyId);
	Review findReview(Long companyId,Long reviewId);
	boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
	boolean deleteReview(Long companyId, Long reviewId);
}
