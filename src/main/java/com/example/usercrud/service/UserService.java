package com.example.usercrud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usercrud.entity.User;

public interface UserService extends IService<User> {

    Page<User> page(int pageNum, int pageSize);

}
