package com.ezan.DataSource.druid;

import com.ezan.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//使用Druid工具类
public class druidDemo2 {
    public static void main(String[] args) {
        //完成添加的操作
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //String sql = "delete from account where id = ?";
            ///3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"alex");
            pstmt.setDouble(2,3000);

            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            JDBCUtils.close(pstmt,conn);
        }



    }
}
