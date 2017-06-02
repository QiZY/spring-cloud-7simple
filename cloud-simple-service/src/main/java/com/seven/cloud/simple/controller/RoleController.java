package com.seven.cloud.simple.controller;

import com.seven.cloud.simple.domain.Role;
import com.seven.cloud.simple.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QiZY on 2017-6-1.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Role getById(@PathVariable("id") Long id) {
        return roleService.getById(id);
    }
}
