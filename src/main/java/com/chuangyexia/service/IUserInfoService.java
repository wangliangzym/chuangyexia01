package com.chuangyexia.service;

import com.chuangyexia.entity.UserInfo;
import com.chuangyexia.entity.UserInfoVo;

public interface IUserInfoService {

    /**
     * 添加用户信息
     * @return
     */
    Integer userAdd(UserInfo userInfo);

    /**
     * 通过电话获取用户信息
     * @param userTel
     * @return
     */
    UserInfoVo getUserInfoByTel(String userTel);
}
