package com.anderfred.mybatis.resource;

import com.anderfred.mybatis.mapper.UserMapper;
import com.anderfred.mybatis.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/user/")
public class UserResource {

    private UserMapper userMapper;

    public UserResource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/update")
    public List<User> update() {
        User user = new User();
        user.setName("ex");
        user.setSalary("20000");
        userMapper.insert(user);
        return userMapper.findAll();
    }
}


