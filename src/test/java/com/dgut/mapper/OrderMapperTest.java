package com.dgut.mapper;

import com.dgut.domain.AppointLog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void TestGetIncompleteAppoint(){
        List<AppointLog> list = orderMapper.getIncompleteAppoint("ajsdoajaspodpojqwd");
        for(AppointLog log:list) System.out.println(log);
    }

    @Test
    public void TestInsertAppointInfo(){
        AppointLog appointLog = new AppointLog("ajsdoajaspodpojqwd", 0);
        Assert.assertSame("Test: OrderMapperTest:TestInsertAppointInfo Failed!",
                1, orderMapper.insertAppointInfo(appointLog));
    }

    @Test
    public void TestUpdateAppointStatus(){
        orderMapper.updateAppointStatus("ajsdoajaspodpojqwd");
    }

    @Test
    public void TestAppointList(){
        List<AppointLog> list = orderMapper.getAppointList("ajsdoajaspodpojqwd");
        for (AppointLog log:list) System.out.println(log);
    }
}
