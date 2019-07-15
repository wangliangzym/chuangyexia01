package com.chuangyexia.service.impl;

import com.chuangyexia.dao.UserLeaveMessageMapper;
import com.chuangyexia.entity.UserLeaveMessage;
import com.chuangyexia.service.IUserLeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLeaveMessageServiceImpl implements IUserLeaveMessageService {

    @Autowired
    UserLeaveMessageMapper userLeaveMessageMapper;

    @Override
    public Integer addLeaveMessage(UserLeaveMessage userLeaveMessage) {
        return userLeaveMessageMapper.addLeaveMessage(userLeaveMessage);
    }
}
