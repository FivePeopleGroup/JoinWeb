package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/10.
 */
@Service("userService")
public class UserServicelmpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    protected CommonDao commonDao;


    /**
     * 增加用户
     * @param user
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addUser(User user) throws SSException {
      if(Assert.isNull(user)){
          return;
      }
      try{
          userMapper.addUser(user);
      } catch (Exception e) {
          LogClerk.errLog.error(e);
          throw SSException.get(NFException.AddUser, e);
      }

    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteUser(int id) throws SSException {
       if(Assert.lessOrEqualZero(id)){
           return false;
       }try{
            return userMapper.deleteUser(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DeleteUser, e);
        }
    }

    /**
     * 修改用户
     * @param user
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateUser(User user) throws SSException {
        if(Assert.isNull(user)){
            return;
        }try{
            userMapper.updateUser(user);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateUser, e);
        }

    }


    /**
     * 列出全部用户
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public List<User> listAll() throws SSException {
        List<User> userList = Collections.emptyList();
        try{
            userList = userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListAllUser,e);
        }
        return userList;
    }


    /**
     * 根据id查找用户
     * @param id
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public User queryUserById(int id) throws SSException {
       if(Assert.lessOrEqualZero(id)){
           return null;
       }try{
            return userMapper.queryUserById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserById,e);
        }
    }


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public User queryUserByName(String username) throws SSException {
        if(Assert.isNull(username)){
            return null;
        }try{
            return userMapper.queryUserByName(username);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListAllUser,e);
        }
    }
}
