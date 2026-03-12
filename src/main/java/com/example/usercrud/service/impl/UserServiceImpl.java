package com.example.usercrud.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usercrud.entity.User;
import com.example.usercrud.mapper.UserMapper;
import com.example.usercrud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> page(int pageNum, int pageSize) {
        return page(new Page<>(pageNum, pageSize));
    }

}
