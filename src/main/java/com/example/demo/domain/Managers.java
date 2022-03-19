package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName managers
 */
@Data
public class Managers implements Serializable {
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
    private String account;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String phonenum;

    /**
     * 
     */
    private Integer managerstatus;

    /**
     * 
     */
    private Integer level;

    /**
     * 
     */
    private Date registertime;

    private static final long serialVersionUID = 1L;
}