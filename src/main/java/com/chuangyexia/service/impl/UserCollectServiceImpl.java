package com.chuangyexia.service.impl;

import com.chuangyexia.dao.UserCollectMapper;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.service.IUserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserCollectServiceImpl implements IUserCollectService {

    @Autowired
    UserCollectMapper userCollectMapper;

    @Override
    @Transactional
    public Integer addUserCollect(Long companyId, String userTel) {
        return userCollectMapper.addUserCollect(companyId,userTel);
    }

    @Override
    public List<CompanyInfoVo> selectCollectByTel(String userTel) {
        return userCollectMapper.selectCollectByTel(userTel);
    }
}
