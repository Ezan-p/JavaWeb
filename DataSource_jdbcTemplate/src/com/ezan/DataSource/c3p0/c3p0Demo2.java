package com.ezan.DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource,使用默认配置
        DataSource ds = new ComboPooledDataSource();
        //使用指定名称的配置
        //DataSource ds = new ComboPooledDataSource(“other c3p0名字”);
        //2.获取连接
        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+1 + ":" + conn);
            if(i==5){
                conn.close();
            }
        }

    }
}
