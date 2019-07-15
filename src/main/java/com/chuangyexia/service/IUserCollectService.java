package com.chuangyexia.service;

import com.chuangyexia.entity.CompanyInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserCollectService {

    /**
     * 收藏
     * @param companyId
     * @param userTel
     * @return
     */
    Integer addUserCollect(Long companyId,String userTel);

    /**
     * 获取我的收藏列表
     * @param userTel
     * @return
     */
    List<CompanyInfoVo> selectCollectByTel(String userTel);

}
