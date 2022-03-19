package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dictionary
 */
@Data
public class Dictionary implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer relationid;

    /**
     * 
     */
    private String relationname;

    /**
     * 
     */
    private String relationvalue;

    private static final long serialVersionUID = 1L;
}