package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName rotation
 */
@Data
public class Rotation implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String information;

    /**
     * 
     */
    private Integer rotationstatus;

    /**
     * 
     */
    private Integer location;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}