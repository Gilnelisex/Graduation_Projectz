package com.example.demo.mapper;

import com.example.demo.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Forzh
* @description 针对表【review】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Review
*/
public interface ReviewMapper {

    List<Review> selectAllReviews(@Param("review") Review review,
                                  @Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize);

    List<Review> selectNewReview();

    int deleteByPrimaryKey(Integer id);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);

    int updateVisit(Integer id);

}
