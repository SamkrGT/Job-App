package com.mycompany.gethired.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.gethired.company.Company;
import com.mycompany.gethired.company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository reviewRepository;
	private CompanyService companyService;
	

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.findCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Review> findAllReviews(Long companyId) {
		return reviewRepository.findByCompanyId(companyId);
	}

	@Override
	public Review findReview(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getReviewId()
				.equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId,Long reviewId, Review updatedReview) {
		if(reviewRepository.findByCompanyId(companyId) != null) {
			updatedReview.setCompany(companyService.findCompanyById(companyId));
			updatedReview.setReviewId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(reviewRepository.findByCompanyId(companyId) != null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			companyService.updateCompany(companyId, company);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}



}
