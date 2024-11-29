package com.ezan.JdbcTemplate;


import com.ezan.domain.Emp;
import com.ezan.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*需求：
1.修改1号数据的 salary 为 10000
2.添加一条记录
3.删除刚才添加的记录
4.查询id为1的记录，将其封装为Map集合
5.查询所有记录，将其封装为List
6.查询所有记录，将其封装为Emp对象的List集合
7.查询总记录数
* */
public class JdbcTemplatePractice {
    //junit单元测试，让方法独立执行
    //1.获取JdbcTemplate对象
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //修改1号数据的 salary 为 10000
    @Test
    public void test1(){
        //2.定义sql1.修改1号数据的 salary 为 10000
        String sql = "update emp set salary = ? where id = ?";
        //3.执行sql
        int count = template.update(sql,10000,1001);
        System.out.println(count);
    }

    //添加一条记录
    @Test
    public void test2(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql,1015,"郭靖",10);
        System.out.println(count);
    }

    //删除刚才添加的记录
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql,1015);
        System.out.println(count);
    }

    //查询id为1的记录，将其封装为Map集合
    //注意：这个方法查询的结果集长度只能是1
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql,1001);
        System.out.println(map);
    }

    //查询所有记录，将其封装为List
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    //查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6_1(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                //获取数据
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                //创建emp对象
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    //用实现类简化test6
    @Test
    public void test6_2(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    //查询总记录数
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
