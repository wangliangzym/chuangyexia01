package com.chuangyexia.controller;

import com.chuangyexia.entity.CompanyInfoVo;
import com.chuangyexia.entity.UserInfo;
import com.chuangyexia.entity.UserInfoVo;
import com.chuangyexia.service.IUserCollectService;
import com.chuangyexia.service.IUserInfoService;
import com.chuangyexia.utils.AjaxResult;
import com.chuangyexia.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    IUserCollectService userCollectService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @RequestMapping("/userAdd")
    public AjaxResult userAdd(UserInfo userInfo){
        Integer integer = userInfoService.userAdd(userInfo);
        if (integer > 0){
            return AjaxResult.success("注册成功");
        }
        return AjaxResult.failed("注册失败");
    }

    /**
     * 用户登录
     * @param userTel
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    public AjaxResult userLogin(@RequestParam("userTel") String userTel,
                                @RequestParam("password") String password){
        UserInfoVo userInfoVo = userInfoService.getUserInfoByTel(userTel);
        if(Objects.isNull(userInfoVo)){
            return AjaxResult.failed("用户名不存在");
        }
        String md5String = MD5Utils.getMD5String(password);
        if(!md5String.equals(userInfoVo.getPassword())){
            return AjaxResult.failed("密码错误");
        }
        //登录成功返回用户id
        Map<String,Object> results = new HashMap<>();
        results.put("id",userInfoVo.getId());
        results.put("username",userInfoVo.getUsername());
        results.put("userTel",userInfoVo.getUserTel());
        return AjaxResult.success(results);
    }

    /**
     * @param userTel 通过用户手机号获取所有收藏
     * @return
     */
    @RequestMapping("/selectCollectByTel")
    public AjaxResult selectCollectByTel(@RequestParam("userTel") String userTel){
        List<CompanyInfoVo> companyInfoVos = userCollectService.selectCollectByTel(userTel);
        return AjaxResult.success(companyInfoVos);
    }
}
