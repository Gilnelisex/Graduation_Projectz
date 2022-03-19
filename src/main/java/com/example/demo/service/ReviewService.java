package com.example.demo.service;

import com.example.demo.domain.Review;

import java.util.List;

/**
* @author Forzh
* @description 针对表【review】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface ReviewService {

    List<Review> selectAllReviews(Review record, Integer pageNum, Integer pageSize);

    List<Review> selectNewReview();

    Review selectByPrimaryKey(Integer id);

    int updateVisit(Integer id);

}
