package com.example.demo.service.impl;

import com.example.demo.domain.Review;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Forzh
* @description 针对表【review】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public List<Review> selectAllReviews(Review record, Integer pageNum, Integer pageSize) {
        return this.reviewMapper.selectAllReviews(record, pageNum, pageSize);
    }

    @Override
    public List<Review> selectNewReview() {
        return this.reviewMapper.selectNewReview();
    }

    @Override
    public Review selectByPrimaryKey(Integer id) {
        return this.reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateVisit(Integer id) {
        return this.reviewMapper.updateVisit(id);
    }
}
