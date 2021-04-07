package org.yunhyerim.api.review.service;

import org.yunhyerim.api.review.domain.Review;

public interface ReviewService {
    String update(Review review);
    String deleteById(long id);
}