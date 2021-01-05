package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {


        // 配置fdfs的全局连接地址
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();// 获得配置文件路径

        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = trackerClient.getTrackerServer();

        // 通过tracker获得一个Storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String[] uploadInfo = storageClient.upload_file("H:/DEBUG.png", "png", null);

        String url = "http://192.168.84.129";

        for (String uploadInfos : uploadInfo) {
            url += "/" + uploadInfos;
            System.out.println(url);
            System.out.println(uploadInfos);

        }

    }

}
