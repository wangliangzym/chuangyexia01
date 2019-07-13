package com.chuangyexia.controller;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.service.ICompanyInfoService;
import com.chuangyexia.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("companyInfo")
public class CompanyInfoController {

    @Autowired
    ICompanyInfoService companyInfoService;

    @RequestMapping("/getCompanyInfoList")
    public AjaxResult getCompanyInfoList(CompanyInfo companyInfo){
        List<CompanyInfoVo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        return AjaxResult.success(companyInfoList);
    }
}
