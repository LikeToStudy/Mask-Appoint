package com.dgut.mapper;

import com.dgut.domain.Contact;
import com.dgut.domain.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackMapper {
    int insertMessage(Message message);

    int insertContact(Contact contact);
}
