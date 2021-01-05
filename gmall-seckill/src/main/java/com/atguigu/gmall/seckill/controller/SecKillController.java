package com.atguigu.gmall.seckill.controller;

import com.atguigu.gmall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/12/31/031 13:12
 **/

@Controller
public class SecKillController {


    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("kill")
    @ResponseBody
    public String kill() {
        String memberId = "1";

        Jedis jedis = redisUtil.getJedis();

        jedis.incrBy("114",-1);

        return "1";
    }
}
