package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GameDto {
    private Integer id;
    private String image_url;
    private String name;
    private Integer partnerId;
    private String description;
    private String linkIos;
    private String linkAndroid;
    private Integer status;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
}
