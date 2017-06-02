package com.seven.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiZY on 2017-6-1.
 */
@Service
public class SimpleService {
    @Autowired
    RestTemplate restTemplate;

    final String SERVICE_NAME = "cloud-simple-service";

    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    public List<User> list() {
        List<User> users = restTemplate.getForObject("http://" + SERVICE_NAME + "/user/list", List.class);
        //return feignUserService.readUserInfo();
        return users;
    }

    private List<User> fallbackSearchAll() {
        System.out.println("HystrixCommand fallbackMethod handle!");
        List<User> ls = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("TestHystrixCommand");
        ls.add(user);
        return ls;
    }
}
