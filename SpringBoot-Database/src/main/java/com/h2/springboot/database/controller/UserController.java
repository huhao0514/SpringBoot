package com.h2.springboot.database.controller;

import com.h2.springboot.database.dao.UserRepository;
import com.h2.springboot.database.entity.User;
import com.h2.springboot.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by: huhao
 * Date: 2020/9/8
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository; //注入jpa接口,不需要实现类

    @GetMapping("getUserById")
    public User getUserById(@RequestParam Long id){
        if(null == id){
            return null;
        }
        //User user = userRepository.findById(id).get(); //jpa自带方法
        User user = userRepository.queryUserById(id);
        return user;
    }

    @GetMapping("getUserByName")
    public List<User> getUserByName(@RequestParam(name="userName") String userName){
        if(null == userName){
            return null;
        }
        //按照一定规则命名的方法,可以不写任何代码完成逻辑调用记得拼接%
        List<User> user = userRepository.findByUserNameLike("%"+userName+"%");
        return user;
    }

    @GetMapping("getUserByNote")
    public List<User> getUserByNote(@RequestParam(name="note") String note){
        if(null == note){
            return null;
        }

        
        return null;
    }

    @GetMapping("getUser")
    public PageResult<User> getUser(@RequestParam(name="pageNo") int pageNo,
                                    @RequestParam(name="pageSize") int pageSize){
        //起始页为0
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> all = userRepository.findAll(pageable);
        return new PageResult<>(all);
    }

    @GetMapping("getUser2")
    public PageResult<User> getUser2(@RequestParam(name="pageNo") int pageNo,
                                    @RequestParam(name="pageSize") int pageSize){
        //起始页为0
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> all = userRepository.findAllUser(pageable);
        return new PageResult<User>(all);
    }
}
