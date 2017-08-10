package com.pandawork.mapper;


import com.pandawork.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户登录Mapper
 * newframework
 * Created by TestUser on 2017/8/10.
 */
public interface UserMapper {

    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    public void addUser (@Param("user") User user) throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @return boolean
     * @throws Exception
     */
    public boolean deleteUser(@Param("id") int id)throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    public void updateUser(@Param("user") User user)throws Exception;


    /**
     * 列出全部用户
     * @return
     * @throws Exception
     */
    public List<User> listAll() throws Exception;


    /**
     * 根据id查找用户
     * @param id
     * @return
     * @throws Exception
     */
    public  User queryUserById(@Param("id") int id) throws Exception;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws Exception
     */
    public User queryUserByName(@Param("username") String username)throws Exception;




}
