package com.chuangyexia.dao;

import com.chuangyexia.entity.UserInfo;
import com.chuangyexia.entity.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {

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
    UserInfoVo getUserInfoByTel(@Param("userTel") String userTel);
}
