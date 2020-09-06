package com.dgut.mapper;

import com.dgut.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestIsUserExist(){
        String uid = userMapper.getUIDByUsername("张三");
        System.out.println(uid);
    }

    @Test
    public void TestGetUIDByUserInfo(){
        String uid = userMapper.getUIDByUserInfo("张三", "123123");
        System.out.println(uid);
    }

    @Test
    public void TestInsertUserInfo(){
        User user = new User("test-user"+UUID.randomUUID().toString(), "123123");
        int result = userMapper.addUser(user);
        System.out.println(result);
    }

    @Test
    public void TestGetUsernameByUID(){
        String userID = "00e75dae-1313-436b-b376-063f774f5559";
        String name = userMapper.getUsernameByUID(userID);
        System.out.println(name);
    }

    @Test
    public void TestGetUser(){
        String userID = "ajsdoajaspodpojqwd";
        User user = userMapper.getUser(userID);
        System.out.println(user);
    }

    @Test
    public void TestIsOfferAddressInfo(){
        String uid = userMapper.isOfferAddressInfo("adsiajdsiadwqdqwd");
        System.out.println(uid);
    }

    @Test
    public void TestUpdateAllInfo(){
        String uid = "adsiajdsiadwqdqwd";
        String name = "嗡嗡嗡";
        String userSex = "男";
        User user = new User(uid, name, userSex, null, null, null, "中山大道", null, null);
        Assert.assertSame("Test: TestUserMapper:TestUpdateAllInfo Failed!",
                1, userMapper.updateAllInfo(user));
    }
}
