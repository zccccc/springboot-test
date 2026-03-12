package com.example.usercrud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usercrud.common.Result;
import com.example.usercrud.entity.User;
import com.example.usercrud.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 分页查询用户列表
     */
    @GetMapping
    public Result<Page<User>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(userService.page(pageNum, pageSize));
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return Result.fail(404, "User not found");
        }
        return Result.success(user);
    }

    /**
     * 新增用户
     */
    @PostMapping
    public Result<User> save(@RequestBody User user) {
        userService.save(user);
        return Result.success(user);
    }

    /**
     * 更新用户
     */
    @PutMapping("/{id}")
    public Result<User> update(@PathVariable Long id, @RequestBody User user) {
        if (userService.getById(id) == null) {
            return Result.fail(404, "User not found");
        }
        user.setId(id);
        userService.updateById(user);
        return Result.success(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        if (userService.getById(id) == null) {
            return Result.fail(404, "User not found");
        }
        userService.removeById(id);
        return Result.success();
    }

}
