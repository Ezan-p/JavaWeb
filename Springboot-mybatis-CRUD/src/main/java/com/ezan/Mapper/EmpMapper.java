package com.ezan.Mapper;

import com.ezan.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    @Insert("insert into emp( username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")         //占位符里填对象的属性值
    public void insert(Emp emp);

    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},"+
            "job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    @Select("Select * from emp where id =#{id}")
    public Emp  getById(Integer id);

    //条件查询
/*    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and "+
            "entrydate between #{begin} and #{end} order by update_time desc")*/
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);

    //动态更新员工信息
    public void update2(Emp emp);

    //批量删除员工
    public void deleteByIds(List<Integer> ids);
}
