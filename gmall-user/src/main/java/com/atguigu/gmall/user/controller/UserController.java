package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/10/12/012 20:50
 **/

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);

        return umsMemberReceiveAddresses;
    }


    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = userService.getAllUser();

        return umsMembers;
    }


    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "hello user";
    }
}
