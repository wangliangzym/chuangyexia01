package com.chuangyexia.controller;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.entity.CompanyTypeMasterVo;
import com.chuangyexia.entity.UserLeaveMessage;
import com.chuangyexia.service.ICompanyInfoService;
import com.chuangyexia.service.ICompanyTypeMasterService;
import com.chuangyexia.service.IUserCollectService;
import com.chuangyexia.service.IUserLeaveMessageService;
import com.chuangyexia.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("companyInfo")
public class CompanyInfoController {

    @Autowired
    ICompanyInfoService companyInfoService;

    @Autowired
    ICompanyTypeMasterService companyTypeMasterService;

    @Autowired
    IUserLeaveMessageService userLeaveMessageService;

    @Autowired
    IUserCollectService userCollectService;

    /**
     * 首页初始化
     * @return
     */
    @RequestMapping("/homePageInit")
    public AjaxResult homePageInit(){
        //todo 1.获取轮播图
        //2.获取所有分类
        List<CompanyTypeMasterVo> companyTypes = companyTypeMasterService.getAllType();
        //3.创业头条
        //4.猜你喜欢

        return AjaxResult.success();
    }

    /**
     * 根据相关参数获取公司列表
     * @param companyInfo
     * @return
     */
    @RequestMapping("/getCompanyInfoList")
    public AjaxResult getCompanyInfoList(CompanyInfo companyInfo){
        List<CompanyInfoVo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        return AjaxResult.success(companyInfoList);
    }

    /**
     * 获取公司详情
     * @param companyInfo
     * @return
     */
    @RequestMapping("/getCompanyInfoDetail")
    public AjaxResult getCompanyInfoDetailByParam(CompanyInfo companyInfo){
        CompanyInfoVo companyInfoDetail = companyInfoService.getCompanyInfoDetailByParam(companyInfo);
        //todo 看了又看
        return AjaxResult.success(companyInfoDetail);
    }

    /**
     * 客户留言
     * @param userLeaveMessage
     * @return
     */
    @RequestMapping("/addLeaveMessage")
    public AjaxResult addLeaveMessage(UserLeaveMessage userLeaveMessage){
        Integer result = userLeaveMessageService.addLeaveMessage(userLeaveMessage);
        if ( result > 0 ){
            return AjaxResult.success("留言成功");
        }
        return AjaxResult.failed("留言失败");
    }

    /**
     * 收藏
     * @param companyId 公司id
     * @param userTel 用户电话(用用户的电话关联用户的收藏)
     * @return
     */
    @RequestMapping("/addUserCollect")
    public AjaxResult addUserCollect(@RequestParam("companyId") Long companyId,
                                     @RequestParam("userTel") String userTel){
        Integer result = userCollectService.addUserCollect(companyId, userTel);
        if(result > 0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.failed("添加失败");
    }


}
