package org.yunhyerim.api.review.repository;

import java.util.List;

import org.yunhyerim.api.review.domain.ReviewExhbnDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import org.yunhyerim.api.review.domain.Review;
import org.yunhyerim.api.review.domain.ReviewDTO;

interface ReviewCustomRepository{
	public List<ReviewDTO> findByUserNum(long UserNum);
	public List<ReviewExhbnDTO> findReview();
	public ReviewExhbnDTO findUsername(long id);
	public List<ReviewExhbnDTO> findByExhbn(long id);
	public List<ReviewExhbnDTO> findByUser(long id);
	public ReviewExhbnDTO findByReveiwNum(long id);
}

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {
	
}
