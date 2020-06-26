package com.chuanhao.blog.dao;

import com.chuanhao.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 根据ID删除
     * @param userId 用户ID
     * @return 影响行数
     */
    int deleteById(Integer userId);

    /**
     * 添加
     * @param user 用户对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 根据ID查询
     * @param userId 用户ID
     * @return 用户对象
     */
    User getUserById(Integer userId);

    /**
     * 更新
     * @param user 用户
     * @return 影响的行数
     */
    int update(User user);

    /**
     * 获的用户列表
     * @return 用户列表
     */
    List<User> listUser();

    /**
     * 根据用户或者email获得用户
     * @param str 用户名或者email
     * @return 用户对象
     */
    User getUserByNameOrEmail(String str);

    /**
     * 根据用户名查用户
     *
     * @param name 用户名
     * @return 用户
     */
    User getUserByName(String name) ;

    /**
     * 根据Email查询用户
     *
     * @param email 邮箱
     * @return 用户
     */
    User getUserByEmail(String email) ;
}
