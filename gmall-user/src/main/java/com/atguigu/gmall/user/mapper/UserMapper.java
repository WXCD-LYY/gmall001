package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company: CUG
 * @Description: TODO
 * @Author: LiYangyong
 * @Date: 2020/10/12/012 20:54
 **/
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
