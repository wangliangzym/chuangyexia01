package com.chuangyexia.dao;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyInfoMapper {
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
    CompanyInfoVo getCompanyInfoDetailById(@Param("id") Long id);

    /**
     * 看了又看列表
     * @param companyType
     * @return
     */
    List<CompanyInfoVo> getLookAgainList(@Param("companyType") String companyType);

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
