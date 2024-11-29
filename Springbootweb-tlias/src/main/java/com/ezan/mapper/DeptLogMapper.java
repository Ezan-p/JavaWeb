package com.ezan.mapper;

import com.ezan.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(creat_time, description) values (#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
