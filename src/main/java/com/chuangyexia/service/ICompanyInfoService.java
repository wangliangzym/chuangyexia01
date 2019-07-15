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

    /**
     * 根据指定参数获取公司信息详情
     * @param companyInfo
     * @return
     */
    CompanyInfoVo getCompanyInfoDetailByParam(CompanyInfo companyInfo);
}
