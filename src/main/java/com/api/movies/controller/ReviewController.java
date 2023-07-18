package com.api.movies.controller;

import com.api.movies.model.BaseResponse;
import com.api.movies.model.Review;
import com.api.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1")
public class ReviewController {

    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/getMovieReviews/{movieId}")
    public ResponseEntity<List<Map<String, Object>>> getMovieReviews(@PathVariable String movieId) {
        int id = Integer.parseInt(movieId);
        return ResponseEntity.ok(reviewService.getMovieReview(id));
    }

    @PostMapping(value = "/create", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.createReview(review),CREATED);
    }
}
