package com.chuangyexia.dao;

import com.chuangyexia.entity.CompanyTypeMasterVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyTypeMasterMapper {

    /**
     * 获取所有的产品分类
     * @return
     */
    List<CompanyTypeMasterVo> getAllType();
}
