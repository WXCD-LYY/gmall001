package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.OmsOrder;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/12/21/021 20:47
 **/
public interface OrderService {

    String checkTradeCode(String memberId, String tradeCode);

    String genTradeCode(String memberId);


    void saveOrder(OmsOrder omsOrder);


    OmsOrder getOrderByOutTradeNo(String outTradeNo);

    void updateOrder(OmsOrder omsOrder);
}

