package com.atguigu.gmall.manage.controller;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/11/14/014 14:08
 **/
public class TestFdfs {

    public static void main(String[] args) {

        String originalFilename = "123.123.123.1215.jpg";
        int i = originalFilename.lastIndexOf(".");
        String extName = originalFilename.substring(i + 1);
        System.out.println(extName);
    }
}
