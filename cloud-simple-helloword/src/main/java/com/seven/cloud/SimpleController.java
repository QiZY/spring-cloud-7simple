package com.seven.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by QiZY on 2017-5-23.
 */
@Controller
public class SimpleController {

    @Autowired
    private SimpleService simpleService;

    @ResponseBody
    @RequestMapping(value = "/")
    String home() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping(value = "/user/list")
    List<User> list() {
        return simpleService.list();
    }

}
