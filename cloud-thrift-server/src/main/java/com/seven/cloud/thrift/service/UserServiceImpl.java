package com.seven.cloud.thrift.service;

import com.seven.cloud.thrift.interfaces.UserDto;
import com.seven.cloud.thrift.interfaces.UserService;
import org.apache.thrift.TException;

/**
 * Created by QiZY on 2017-5-27.
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public UserDto getUser() throws TException {
        UserDto user = new UserDto(1000, "david");
        return user;
    }
}
