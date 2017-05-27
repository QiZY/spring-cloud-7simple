package com.seven.cloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seven.cloud.ui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiZY on 2017-5-25.
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    //	 @Autowired
    //	 FeignUserService feignUserService;

    final String SERVICE_NAME = "cloud-simple-service";

    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    public List<User> list() {
        List<User> users = restTemplate.getForObject("http://" + SERVICE_NAME + "/user/list", List.class);
        //return feignUserService.readUserInfo();
        return users;
    }

    private List<User> fallbackSearchAll() {
        System.out.println("HystrixCommand fallbackMethod handle!");
        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("TestHystrixCommand");
        ls.add(user);
        return ls;
    }
}
