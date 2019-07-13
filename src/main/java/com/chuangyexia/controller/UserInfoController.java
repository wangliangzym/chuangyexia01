package com.chuangyexia.controller;

import com.chuangyexia.entity.UserInfo;
import com.chuangyexia.entity.UserInfoVo;
import com.chuangyexia.service.IUserInfoService;
import com.chuangyexia.utils.AjaxResult;
import com.chuangyexia.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping("/userAdd")
    public AjaxResult userAdd(UserInfo userInfo){
        Integer integer = userInfoService.userAdd(userInfo);
        if (integer > 0){
            return AjaxResult.success("注册成功");
        }
        return AjaxResult.failed("注册失败");
    }

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

        return AjaxResult.success("登录成功");
    }
}
