package com.chuangyexia.controller;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.entity.CompanyTypeMasterVo;
import com.chuangyexia.service.ICompanyInfoService;
import com.chuangyexia.service.ICompanyTypeMasterService;
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

    @Autowired
    ICompanyTypeMasterService companyTypeMasterService;

    @RequestMapping("/homePageInit")
    public AjaxResult homePageInit(){
        //todo 1.获取轮播图
        //2.获取所有分类
        List<CompanyTypeMasterVo> companyTypes = companyTypeMasterService.getAllType();
        //3.创业头条
        //4.猜你喜欢

        return AjaxResult.success();
    }

    @RequestMapping("/getCompanyInfoList")
    public AjaxResult getCompanyInfoList(CompanyInfo companyInfo){
        List<CompanyInfoVo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        return AjaxResult.success(companyInfoList);
    }


}
