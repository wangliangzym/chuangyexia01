package com.chuangyexia.controller;

import com.chuangyexia.entity.CompanyInfo;
import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.entity.CompanyTypeMasterVo;
import com.chuangyexia.entity.UserLeaveMessage;
import com.chuangyexia.entity.responseParam.ComInfoDetailResp;
import com.chuangyexia.entity.responseParam.MoneyAreaResp;
import com.chuangyexia.enums.MoneyDomainEnum;
import com.chuangyexia.service.ICompanyInfoService;
import com.chuangyexia.service.ICompanyTypeMasterService;
import com.chuangyexia.service.IUserCollectService;
import com.chuangyexia.service.IUserLeaveMessageService;
import com.chuangyexia.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //1.获取轮播图(店铺数量排名前三)
        List<CompanyInfoVo> carouselPics = companyInfoService.getCarouselPic();
        //同步大图
        carouselPics.stream().forEach(carouselPic ->{
            carouselPic.setBigPicUrl(getBigPic(carouselPic.getBigPicUrl(),request));
        });
        //2.获取所有分类
        List<CompanyTypeMasterVo> companyTypes = companyTypeMasterService.getAllType();
        //3.创业头条(申请数量排名前二)
        List<CompanyInfoVo> businessTops = companyInfoService.getBusinessTop();
        businessTops.stream().forEach(businessTop -> {
            businessTop.setBigPicUrl(getBigPic(businessTop.getBigPicUrl(),request));
        });
        //4.猜你喜欢
        List<CompanyInfoVo> lookAgainList = companyInfoService.getLookAgainList("2");
        lookAgainList.stream().forEach(lookAgain ->{
            lookAgain.setSmallPicUrl(getSmallPic(lookAgain.getSmallPicUrl(),request));
        });

        Map<String,Object> results = new HashMap<>();
        results.put("carouselPicList",carouselPics);
        results.put("companyTypeList",companyTypes);
        results.put("businessTopList",businessTops);
        results.put("lookAgainList",lookAgainList);

        return AjaxResult.success(results);
    }

    /**
     * 根据相关参数获取公司列表(分类列表)
     * @param companyInfo
     * @return
     */
    @RequestMapping("/getCompanyInfoList")
    public AjaxResult getCompanyInfoList(CompanyInfo companyInfo,HttpServletRequest request){
        PageHelper.startPage(companyInfo.getPageIndex(),companyInfo.getPageSize());
        List<CompanyInfoVo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        //根据图图片名称获取公司相应小图片
        companyInfoList.stream().forEach(company ->{
            company.setSmallPicUrl(getSmallPic(company.getSmallPicUrl(),request));
        });
        PageInfo<CompanyInfoVo> pageInfo = new PageInfo<>(companyInfoList);
        return AjaxResult.success(pageInfo.getList());
    }

    /**
     * 获取公司详情
     * @param id
     * @return
     */
    @RequestMapping("/getCompanyInfoDetail")
    public AjaxResult getCompanyInfoDetailByParam(@RequestParam(value = "id") Long id,
                                                  HttpServletRequest request){
        CompanyInfoVo companyInfoDetail = companyInfoService.getCompanyInfoDetailById(id);
        //获取公司大图片
        companyInfoDetail.setBigPicUrl(getBigPic(companyInfoDetail.getBigPicUrl(),request));
        //看了又看，同类型的取三个
        List<CompanyInfoVo> lookAgainList = companyInfoService.getLookAgainList(companyInfoDetail.getCompanyType());
        //同步小图
        lookAgainList.stream().forEach(CompanyInfoVo->{
            CompanyInfoVo.setSmallPicUrl(getSmallPic(CompanyInfoVo.getSmallPicUrl(),request));
        });
        ComInfoDetailResp results = new ComInfoDetailResp();
        BeanUtils.copyProperties(companyInfoDetail,results);
        results.setCompanyInfoVos(lookAgainList);
        return AjaxResult.success(results);
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
            return AjaxResult.success("收藏成功");
        }
        return AjaxResult.failed("收藏失败");
    }

    /**
     * 获取所有公司分类列表
     * @return
     */
    @RequestMapping("/getAllCompanyType")
    public AjaxResult getAllCompanyType(){
        List<CompanyTypeMasterVo> companyTypes = companyTypeMasterService.getAllType();
        return AjaxResult.success(companyTypes);
    }

    /**
     * 获取价格区间列表
     * @return
     */
    @RequestMapping("/getAllMoneyArea")
    public AjaxResult getAllMoneyArea(){
        List<MoneyAreaResp> results = new ArrayList<>();
        for (MoneyDomainEnum value : MoneyDomainEnum.values()) {
            MoneyAreaResp moneyAreaResp = new MoneyAreaResp();
            moneyAreaResp.setCode(value.getCode());
            moneyAreaResp.setName(value.getArea());
            results.add(moneyAreaResp);
        }
        return AjaxResult.success(results);
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
