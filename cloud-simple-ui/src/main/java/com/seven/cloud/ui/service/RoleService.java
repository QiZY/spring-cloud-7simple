package com.seven.cloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seven.cloud.ui.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by QiZY on 2017-6-2.
 */
@Service
public class RoleService {
    @Autowired
    private RestTemplate restTemplate;

    final String SERVICE_NAME = "cloud-simple-service";

    @HystrixCommand(fallbackMethod = "fallbackGetById")
    public Role getById(Long id) {
        Role role = restTemplate.getForObject("http://" + SERVICE_NAME + "/role/get/1", Role.class);
        return role;
    }

    private Role fallbackGetById(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setName("not found");
        role.setDescription("fallback handle");
        return role;
    }
}
