package com.wzl.books.test;

import com.wzl.books.entity.User;
import com.wzl.books.mapper.UserMapper;
import com.wzl.books.utils.Md5;
import com.wzl.books.utils.RandomName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Random;
import java.util.UUID;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

    @Autowired(required = false)
    private UserMapper userMapper;

    /*
    private String id;
    private String username;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer isadmin;
    private String major;
    */
    @Test
    public void test1(){

        for (int i = 0; i < 10; i++) {
            String id = UUID.randomUUID().toString().replace("-","");
            String username = RandomName.getXM(i);
            String password = Md5.getMD5String("1111");
            Integer age = new Random().nextInt(10)+18;
            Integer sex = new Random().nextInt(2);
            Integer isadmin = 0;
            String major = RandomName.getRandomMajor();
            User user = new User(id,username,password,age,sex,isadmin,major);
            userMapper.insertUser(user);
        }
    }
}
