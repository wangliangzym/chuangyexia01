package com.chuangyexia.service;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;

import java.util.List;

public interface ICompanyInfoService {

    /**
     * 获取店家列表
     * @param companyInfo
     * @return
     */
    List<CompanyInfoVo> getCompanyInfoList(CompanyInfo companyInfo);
}
