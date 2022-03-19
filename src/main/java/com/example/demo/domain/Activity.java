package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName activity
 */
@Data
public class Activity implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String picture;

    /**
     * 
     */
    private Integer field;

    /**
     * 
     */
    private String reason;

    /**
     * 
     */
    private String bright;

    /**
     * 
     */
    private String introduce;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String harvest;

    /**
     * 
     */
    private Integer time;

    private Integer startime;

    private Integer endtime;

    /**
     * 
     */
    private Integer num;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private Integer actstatus;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}