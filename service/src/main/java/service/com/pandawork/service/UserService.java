package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * 用户登陆系统
 * newframework
 * Created by TestUser on 2017/8/10.
 */
public interface UserService {

    /**
     * 增加用户
     *
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws SSException;

    /**
     * 根据id删除用户
     *
     * @param id
     * @return boolean
     * @throws Exception
     */
    public boolean deleteUser(int id) throws SSException;

    /**
     * 修改用户
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws SSException;


    /**
     * 列出全部用户
     *
     * @return
     * @throws Exception
     */
    public List<User> listAll() throws SSException;


    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User queryUserById(int id) throws SSException;

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    public User queryUserByName(String username) throws SSException;

}
