package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName joininfo
 */
@Data
public class Joininfo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer actid;

    private String aname;

    private String apic;

    private Integer baseid;

    /**
     * 
     */
    private Integer userid;

    private String unickname;

    private String uaccount;
    /**
     * 
     */
    private Integer manageid;

    private String mnickname;

    private String mphonenum;

    private String maccount;
    /**
     * 
     */
    private Integer infostatus;

    private String infostatusz;
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
    private String username;

    /**
     * 
     */
    private String userphone;

    /**
     * 
     */
    private String useridno;

    /**
     * 
     */
    private Integer usernums;

    /**
     * 
     */
    private Integer userprices;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointment;

    private static final long serialVersionUID = 1L;
}