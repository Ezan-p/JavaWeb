package com.ezan.service;

import com.ezan.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询全部部门数据
    List<Dept> list();

    //删除部门
    void delete(Integer id);

    void add(Dept dept);

    Dept getDeptById(Integer id);

    void update(Dept dept);
}
