package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName review
 */
@Data
public class Review implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String picture;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Integer reviewstatus;

    /**
     * 
     */
    private Integer visitnum;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private Integer relationact;

    private static final long serialVersionUID = 1L;
}