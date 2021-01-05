package com.atguigu.gmall.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/11/14/014 13:55
 **/
public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {

        String imgUrl = "http://192.168.84.129";

        // 上传图片服务器
        // 配置fdfs的全局连接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件路径

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 通过tracker获得一个Storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        try {

            byte[] bytes = multipartFile.getBytes(); // 获得上传的二进制对象

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename(); // DEBUG.png
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);

            String[] uploadInfo = storageClient.upload_file(bytes, extName, null);


            for (String uploadInfos : uploadInfo) {
                imgUrl += "/" + uploadInfos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return imgUrl;
    }
}
