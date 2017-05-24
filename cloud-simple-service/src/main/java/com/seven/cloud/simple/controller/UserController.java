package com.seven.cloud.simple.controller;

import com.seven.cloud.simple.domain.User;
import com.seven.cloud.simple.request.InsertUserRequest;
import com.seven.cloud.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by QiZY on 2017-5-24.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Long insert(@RequestBody @Valid InsertUserRequest request) {
        return userService.insert(request);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }
}
