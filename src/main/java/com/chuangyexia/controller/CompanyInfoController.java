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

import javax.servlet.http.HttpServletRequest;
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

    private final String BIG_PIC_DIR = "/images/bigPicture/";
    private final String SMALL_PIC_DIR = "/images/smallPicture/";
    /**
     * 首页初始化
     * @return
     */
    @RequestMapping("/homePageInit")
    public AjaxResult homePageInit(HttpServletRequest request){
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
    public AjaxResult getCompanyInfoList(CompanyInfo companyInfo,HttpServletRequest request){
        List<CompanyInfoVo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        //根据图图片名称获取公司相应小图片
        companyInfoList.stream().forEach(company ->{
            company.setSmallPicUrl(getSmallPic(company.getSmallPicUrl(),request));
        });
        return AjaxResult.success(companyInfoList);
    }

    /**
     * 获取公司详情
     * @param companyInfo
     * @return
     */
    @RequestMapping("/getCompanyInfoDetail")
    public AjaxResult getCompanyInfoDetailByParam(CompanyInfo companyInfo,HttpServletRequest request){
        CompanyInfoVo companyInfoDetail = companyInfoService.getCompanyInfoDetailByParam(companyInfo);
        //获取公司大图片
        companyInfoDetail.setBigPicUrl(getBigPic(companyInfoDetail.getBigPicUrl(),request));
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

    /**
     * 通过图片名称获取大图片在服务器地址
     * @param request
     * @return
     */
    public String getBigPic(String picName,HttpServletRequest request){
        String bigPicUrl =
                request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + BIG_PIC_DIR + picName;
        return bigPicUrl;
    }

    /**
     * 通过图片名称获取小图片在服务器地址
     * @param request
     * @return
     */
    public String getSmallPic(String picName,HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + SMALL_PIC_DIR + picName;
    }


}
