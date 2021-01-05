package com.atguigu.gmall.passport.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.util.HttpclientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/12/20/020 10:10
 **/
public class TestOauth2 {

    public static String getCode() {
        // 1. 获得授权码
        // 2019047052
        // http://passport.gmall.com:8085/vlogin


        String s1 = HttpclientUtil.doGet("https://api.weibo.com/oauth2/authorize?client_id=2019047052&response_type=code&redirect_uri=http://passport.gmall.com:8085/vlogin");

        System.out.println(s1);

        // 在第一步和第二步返回回调地址之间，有一个用户操作授权的过程

        // 2 用户在授权完成后,返回授权码到回调地址
        String s2 = "http://passport.gmall.com:8085/vlogin?code=cbf0ec5cf5ca3151e7cf86821e590c82";


        return null;
    }

    public static String getAccess_token() {


        // 3 我们通过授权码code发送post请求到第三方网站，换取access_token
        // 授权码（要即时获得）
        // client_secret=afce0059a09d51720dcfba11e711b57a
        // client_id=2019047052
        String s3 = "https://api.weibo.com/oauth2/access_token"; // ?client_id=2019047052&client_secret=afce0059a09d51720dcfba11e711b57a&grant_type=authorization_code&redirect_uri=http://passport.gmall.com:8085/vlogin&code=CODE";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("client_id", "2019047052");
        paramMap.put("client_secret", "afce0059a09d51720dcfba11e711b57a");
        paramMap.put("grant_type", "authorization_code");
        paramMap.put("redirect_uri", "http://passport.gmall.com:8085/vlogin");
        paramMap.put("code", "cbf0ec5cf5ca3151e7cf86821e590c82");// 授权有效期内可以使用，没新生成一次授权码，说明用户对第三方数据进行重启授权，之前的access_token和授权码全部过期

        String access_token_json = HttpclientUtil.doPost(s3, paramMap);

        Map<String, String> access_map = JSON.parseObject(access_token_json, Map.class);

        System.out.println(access_map.get("access_token"));
        System.out.println(access_map.get("uid"));

        return null;
    }

    public static Map<String, String> getUser_info() {

        // 4. 用access_token查询用户信息
        String s4 = "https://api.weibo.com/2/users/show.json?access_token=2.00pOwYtGC4idMCafdf9dfd95cTZsBE&uid=6317822495";
        String user_json = HttpclientUtil.doGet(s4);
        Map<String, String> user_map= JSON.parseObject(user_json, Map.class);
        System.out.println(user_map.get("1"));

        return user_map;
    }




    public static void main(String[] args) {

        getUser_info();


    }
}
