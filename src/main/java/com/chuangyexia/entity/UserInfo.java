package com.chuangyexia.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInfo {

    private Long id;

    private String username;

    private String password;

    private String userTel;

    private Date createTime;

    private Boolean delFlag;

}
