package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import com.pandawork.test.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.pandawork.*;

/**用户登录测试
 * newframework
 * Created by TestUser on 2017/8/10.
 */
public class UserTest extends AbstractTestCase {
  @Autowired
    UserService userService;

    /**
     * 测试增加用户
     */
    @Test
    public void addUserTest() throws SSException {
        User user = new User();
        user.setUsername("柯招坤");
        user.setPassword("13015994879");
        user.setStatus(1);
        userService.addUser(user);
        System.out.println("添加成功");
    }

    /**
     * 删除用户
     * @throws SSException
     */
    @Test
    public void deleteUserTest()throws SSException{
         userService.deleteUser(2);
        System.out.println("删除成功");
    }

    /**
     * 测试修改类
     * @throws SSException
     */
    @Test
    public void updateUserTest()throws SSException{
        User user = new User();
        user.setUsername("柯招坤");
        user.setPassword("13015994879");
        user.setStatus(2);
        user.setId(1);
        userService.updateUser(user);
    }

    /**
     * 列出全部用户
     * @throws SSException
     */
    @Test
    public void listAllTest() throws SSException {
        System.out.println(userService.listAll());
    }

    /**
     * 通过id查找用户
     * @throws SSException
     */
    @Test
    public void queryByIdTest() throws SSException {
        System.out.println(userService.queryUserById(4));
    }

    /**
     * 通过姓名查找用户
     * @throws SSException
     */
    @Test
    public  void queryByName()throws SSException{
        System.out.println(userService.queryUserByName("小明"));
    }
}
