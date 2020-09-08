package com.h2.springboot.database.dao;

import com.h2.springboot.database.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by: huhao
 * Date: 2020/9/8
 * 一般而言,只需要定义jpa接口扩展JpaRepository,便可以获取jpa提供的方法
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("from user where id=?1 ") //注意此处要写实体类中对应的@Entity中的name
    public User queryUserById(Long id);

    /**
     * 按照一定规则命名的方法,可以不写任何代码完成逻辑
     * @param userName
     * @return
     */
    public List<User> findByUserNameLike(String userName);

   @Query(value = "from user order"
   ,countQuery = "select count(id) from user ")
    public Page<User> findAllUser(Pageable pageable);
}
