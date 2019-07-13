package com.chuangyexia.service;

import com.chuangyexia.entity.CompanyTypeMasterVo;

import java.util.List;

public interface ICompanyTypeMasterService {

    /**
     * 获取所有的产品分类
     * @return
     */
    List<CompanyTypeMasterVo> getAllType();
}
