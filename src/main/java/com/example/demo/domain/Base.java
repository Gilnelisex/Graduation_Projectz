package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName base
 */
@Data
public class Base implements Serializable {
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
    private String name;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Integer hour;

    private Integer starthour;

    private Integer endhour;

    /**
     * 
     */
    private Integer basestatus;

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
    private String province;

    /**
     * 
     */
    private String city;

    private static final long serialVersionUID = 1L;
}