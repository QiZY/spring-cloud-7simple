package com.seven.cloud.ui.controller;

import com.seven.cloud.ui.model.Role;
import com.seven.cloud.ui.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QiZY on 2017-6-2.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/get/{id}")
    public Role getById(@PathVariable("id") Long id) {
        return roleService.getById(id);
    }
}
