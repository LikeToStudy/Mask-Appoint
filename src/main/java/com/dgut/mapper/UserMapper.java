package com.dgut.mapper;

import com.dgut.domain.User;
import org.springframework.stereotype.Repository;

//不加这个注解@Autowired会有红色下划线，但能正常运行
//如果在xml文件中没有配置扫描这个包，那么就需要@Mapper，它相当于@Repository+@MapperScan
@Repository
public interface UserMapper {
    /*select*/

    //根据用户名获取用户ID
    String getUIDByUsername(String username);

    //根据用户名和密码获取用户ID
    String getUIDByUserInfo(String username, String password);

    //根据id获取用户名
    String getUsernameByUID(String UID);

    User getUser(String uid);

    /*insert*/

    //添加一条用户记录

    int addUser(User user);

    //查看是否填写了收件地址和收件码
    String isOfferAddressInfo(String userID);
    /*update*/

    int updateAllInfo(User user);

}
