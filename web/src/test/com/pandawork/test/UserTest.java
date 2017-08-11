package com.pandawork.test;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        user.setUsername("小小");
        user.setPassword("123123");
        user.setStatus(0);
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
        user.setUsername("小冰");
        user.setPassword("111111");
        user.setStatus(0);
        user.setId(13);
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
