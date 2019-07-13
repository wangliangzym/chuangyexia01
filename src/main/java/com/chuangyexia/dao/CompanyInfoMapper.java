package com.chuangyexia.dao;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyInfoMapper {
    /**
     * 获取店家列表
     * @param companyInfo
     * @return
     */
    List<CompanyInfoVo> getCompanyInfoList(CompanyInfo companyInfo);
}
