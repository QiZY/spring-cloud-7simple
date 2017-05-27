package com.seven.cloud.ui.controller;

import com.seven.cloud.ui.model.User;
import com.seven.cloud.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by QiZY on 2017-5-25.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

//	@Autowired
//	FeignUserService feignUserService;

    @RequestMapping(value = "/users")
    public ResponseEntity<List<User>> readUserInfo() {
        List<User> users = userService.list();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
