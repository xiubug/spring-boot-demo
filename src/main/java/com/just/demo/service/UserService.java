package com.just.demo.service;

import com.just.demo.domain.User;

import java.util.List;

/**
 * User 业务层接口
 *
 * Created by apple on 2018/3/21.
 */
public interface UserService {
    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
