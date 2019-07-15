package com.chuangyexia.service.impl;

import com.chuangyexia.dao.CompanyInfoMapper;
import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.service.ICompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService {

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Override
    public List<CompanyInfoVo> getCompanyInfoList(CompanyInfo companyInfo) {
        return companyInfoMapper.getCompanyInfoList(companyInfo);
    }

    @Override
    public CompanyInfoVo getCompanyInfoDetailByParam(CompanyInfo companyInfo) {
        return companyInfoMapper.getCompanyInfoDetailByParam(companyInfo);
    }
}
