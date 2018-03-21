package com.just.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层操作接口
 *
 * Created by apple on 2018/3/21.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
