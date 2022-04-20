package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Review;
import com.eurodyn.team2.repository.ReviewRepository;
import com.eurodyn.team2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService {
    private ReviewRepository reviewRepository;

    @Override
    public JpaRepository<Review, Long> getRepository() {
        return reviewRepository;
    }
}
