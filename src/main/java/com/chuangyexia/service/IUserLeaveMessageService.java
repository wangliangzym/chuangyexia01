package com.chuangyexia.service;

import com.chuangyexia.entity.UserLeaveMessage;

public interface IUserLeaveMessageService {

    /**
     * 添加客户留言
     * @param userLeaveMessage
     * @return
     */
    Integer addLeaveMessage(UserLeaveMessage userLeaveMessage);
}
