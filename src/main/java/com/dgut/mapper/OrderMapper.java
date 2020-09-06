package com.dgut.mapper;

import com.dgut.domain.AppointLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /*select*/
    //获取未完成的预约订单
    List<AppointLog> getIncompleteAppoint(String userID);

    //获取用户的所有预约信息
    List<AppointLog> getAppointList(String userID);

    /*update*/

    //更新预约订单状态
    int updateAppointStatus(String userID);

    /*insert*/
    //插入一条预约信息
    int insertAppointInfo(AppointLog appointLog);
}
