package com.seven.cloud.thrift.client.controller;

import com.seven.cloud.thrift.client.provider.UserServiceProvider;
import com.seven.cloud.thrift.interfaces.UserDto;
import com.seven.cloud.thrift.interfaces.UserService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by QiZY on 2017-5-27.
 */
@Controller
public class UserController {
    @Autowired
    UserServiceProvider userServiceProvider;

    @ResponseBody
    @RequestMapping(value = "/hello")
    String hello() throws TException {
        UserService.Client svr = userServiceProvider.getBalanceUserService();
        UserDto userDto = svr.getUser();
        return "hi " + userDto.getUsername();
    }
}
