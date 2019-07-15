package com.chuangyexia.dao;

import com.chuangyexia.entity.CompanyInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCollectMapper {

    /**
     * 收藏
     * @param companyId
     * @param userTel
     * @return
     */
    Integer addUserCollect(@Param("companyId") Long companyId,@Param("userTel") String userTel);

    /**
     * 获取我的收藏列表
     * @param userTel
     * @return
     */
    List<CompanyInfoVo> selectCollectByTel(@Param("userTel") String userTel);
}
