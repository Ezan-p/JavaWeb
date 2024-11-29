package com.ezan;

import com.ezan.mapper.UserMapper;
import com.ezan.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList =userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

}
