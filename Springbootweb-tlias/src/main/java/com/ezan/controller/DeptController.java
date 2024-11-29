package com.ezan.controller;

import com.ezan.anno.Log;
import com.ezan.pojo.Dept;
import com.ezan.pojo.Result;
import com.ezan.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询全部部门数据
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    //删除部门      --@PathVariable获取路径参数
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }

    //新增部门      --@RequestBody封装为实体类再插入
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //修改部门（先根据ID查询，再修改）-----修改时会先发送一条get请求来获取ID，接着才能修改
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id){
        log.info("根据ID查询部门：{}",id);
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
