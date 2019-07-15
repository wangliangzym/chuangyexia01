package com.chuangyexia.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLeaveMessage {

    private Long id;

    private String companyId;

    private String username;

    private String userTel;

    private String message;

}
