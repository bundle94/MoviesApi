package com.api.movies.service;

import com.api.movies.model.BaseResponse;
import com.api.movies.model.Review;
import com.api.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;


    public List<Map<String, Object>> getMovieReview(int id) {
        return reviewRepository.getAllMovieReviewsByMovieId(id);
    }

    public BaseResponse createReview(Review review) {
        review.setDate_created(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
        return new BaseResponse("00", "Created", null);
    }
}
