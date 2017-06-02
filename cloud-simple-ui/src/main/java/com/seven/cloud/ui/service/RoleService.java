package com.seven.cloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seven.cloud.ui.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by QiZY on 2017-6-2.
 */
@Service
public class RoleService {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RoleClient roleClient;

//    final String SERVICE_NAME = "cloud-simple-service";

    @HystrixCommand(fallbackMethod = "fallbackGetById")
    public Role getById(Long id) {
//        Role role = restTemplate.getForObject("http://" + SERVICE_NAME + "/role/get/1", Role.class);
//        return role;
        return roleClient.getById(id);
    }

    private Role fallbackGetById(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setName("not found");
        role.setDescription("fallback handle");
        return role;
    }

    @FeignClient("cloud-simple-service")
    interface RoleClient {
        @RequestMapping(value = "/role/get/{id}", method = GET)
        Role getById(@PathVariable("id") Long id);
    }
}
