package com.dgut.mapper;

import com.dgut.domain.Contact;
import com.dgut.domain.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class FeedbackMapperTest {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Test
    public void TestInsertMessage(){
        Message message = new Message("asasasassss");
        Assert.assertSame("Test: TestFeedbackMapper:TestInsertMessage Failed!",
                1, feedbackMapper.insertMessage(message));
    }

    @Test
    public void TestInsertContact(){
        Contact contact = new Contact("张三", "niko",
                "aaa@qq.com", "1382929292", "有免费口罩吗？");
        Assert.assertSame("Test: TestFeedbackMapper:TestInsertContact Failed!",
                1, feedbackMapper.insertContact(contact));
    }
}
