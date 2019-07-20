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
     * @param id
     * @return
     */
    CompanyInfoVo getCompanyInfoDetailById(Long id);

    /**
     * 看了又看列表
     * @param companyType
     * @return
     */
    List<CompanyInfoVo> getLookAgainList(String companyType);

    /**
     * 获取首页轮播图
     * @return
     */
    List<CompanyInfoVo> getCarouselPic();

    /**
     * 创业头条
     * @return
     */
    List<CompanyInfoVo> getBusinessTop();
}
