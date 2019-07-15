package com.chuangyexia.dao;

import com.chuangyexia.entity.UserLeaveMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLeaveMessageMapper {

    /**
     * 添加客户留言
     * @param userLeaveMessage
     * @return
     */
    Integer addLeaveMessage(UserLeaveMessage userLeaveMessage);
}
