package com.seven.cloud.simple.service;

import com.seven.cloud.simple.domain.User;
import com.seven.cloud.simple.mapper.UserMapper;
import com.seven.cloud.simple.request.InsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by QiZY on 2017-5-24.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Long insert(InsertUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        userMapper.insert(user);
        return user.getId();
    }

    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public List<User> list() {
        return userMapper.selectAll();
    }
}
