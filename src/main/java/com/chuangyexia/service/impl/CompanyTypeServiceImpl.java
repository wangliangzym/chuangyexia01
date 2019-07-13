package com.chuangyexia.service.impl;

import com.chuangyexia.dao.CompanyTypeMasterMapper;
import com.chuangyexia.entity.CompanyTypeMasterVo;
import com.chuangyexia.service.ICompanyTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTypeServiceImpl implements ICompanyTypeMasterService {

    @Autowired
    CompanyTypeMasterMapper companyTypeMasterMapper;

    @Override
    public List<CompanyTypeMasterVo> getAllType() {
        return companyTypeMasterMapper.getAllType();
    }
}
