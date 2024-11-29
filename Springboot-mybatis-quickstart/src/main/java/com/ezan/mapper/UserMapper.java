package com.ezan.mapper;

import com.ezan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper         //在运行时，会自动生成该接口的实现列对象(代理对象)，并且将该对象交给IOC容器管理
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from user")
    public abstract List<User> list();
}
