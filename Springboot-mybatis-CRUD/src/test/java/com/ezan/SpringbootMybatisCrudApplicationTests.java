package com.ezan;

import com.ezan.Mapper.EmpMapper;
import com.ezan.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(17);
    }

    @Test
    public void testInsert() {
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("max");
        emp.setName("kim");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //执行新增员工信息的操作
        empMapper.insert(emp);
    }

    @Test
    public void testUpdate() {
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("maxU");
        emp.setName("kimU");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //执行新增员工信息的操作
        empMapper.update(emp);
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }

    @Test
    public void testSelectList(){
        //List<Emp> emplist  =empMapper.list("张",(short)1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
        List<Emp> emplist = empMapper.list(null,(short)1,null,null);
        System.out.println(emplist);
    }

    //动态更新
    @Test
    public void testUpdate2() {
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("maxM");
/*        emp.setImage("2.jpg");
        emp.setGender((short)1);
        emp.setUpdateTime(LocalDateTime.now());*/
        //执行新增员工信息的操作
        empMapper.update2(emp);
    }

    //批量删除员工
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(13, 14, 15);
        empMapper.deleteByIds(ids);
    }
}
