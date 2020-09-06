package com.dgut.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class JsonHelperTest {
    @Autowired
    private JsonHelper jsonHelper;

    @Test
    public void TestLogin(){
        String s = jsonHelper.login(1).toJSONString();
        System.out.println(s);
    }

    @Test
    public void TestRegister(){
        String s = jsonHelper.operator(1).toJSONString();
        System.out.println(s);
    }
}
