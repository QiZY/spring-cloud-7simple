package com.seven.cloud.simple.service;

import com.seven.cloud.simple.domain.Role;
import com.seven.cloud.simple.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by QiZY on 2017-6-1.
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role getById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
