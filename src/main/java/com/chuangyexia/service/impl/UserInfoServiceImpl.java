package com.chuangyexia.service.impl;

import com.chuangyexia.dao.UserInfoMapper;
import com.chuangyexia.entity.UserInfo;
import com.chuangyexia.entity.UserInfoVo;
import com.chuangyexia.service.IUserInfoService;
import com.chuangyexia.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public Integer userAdd(UserInfo userInfo) {
        //将密码加密
        String md5String = MD5Utils.getMD5String(userInfo.getPassword());
        userInfo.setPassword(md5String);
        return userInfoMapper.userAdd(userInfo);
    }

    @Override
    public UserInfoVo getUserInfoByTel(String userTel) {
        return userInfoMapper.getUserInfoByTel(userTel);
    }
}
