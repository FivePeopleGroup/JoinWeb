package com.pandawork.web.controller;

import com.pandawork.common.entity.News;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/10.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    /**
     * 跳到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 处理用户登录
     *
     * @param username
     * @param password
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) throws SSException {

        if (Assert.isNull(username)) {
            redirectAttributes.addFlashAttribute("message", "用户名为空，请重新登录！！！");
            return "redirect:/user/login";
        }
        try {
            User user = userService.queryUserByName(username);
            if (Assert.isNull(user)) {
                redirectAttributes.addFlashAttribute("message", "用户名不存在，请重新登录！！！");
                return "redirect:/user/login";
            } else if (password.equals(user.getPassword())) {
                return "redirect:/user/qq/"+user.getId();
            } else {
                redirectAttributes.addFlashAttribute("message", "密码错误，请重新登录！！！");
                return "redirect:/user/login";
            }
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 跳到注册界面
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 注册处理界面
     * @param username
     * @param password
     * @param password2
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("password2") String password2, RedirectAttributes redirectAttributes) {

        if(Assert.isNull(username)||Assert.isNull(password)||Assert.isNull(password2)){
            redirectAttributes.addFlashAttribute("message","用户名、密码均不能为空，请重新注册！！！");
            return "redirect:/user/register";
        }
        try {
            User user = userService.queryUserByName(username);
            if(Assert.isNull(user)){
             if(password.equals(password2)){
                 User user1 = new User();
                 user1.setUsername(username);
                 user1.setPassword(password);
                 user1.setStatus(0);
                 userService.addUser(user1);
                 return "redirect:/user/login";
             }else {
                 redirectAttributes.addFlashAttribute("message","密码输入不一致，请重新注册！！！");
                 return "redirect:/user/register";
             }
            }else{
                redirectAttributes.addFlashAttribute("message","用户名已存在，请重新注册！！！");
                return "redirect:/user/register";
            }
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }


    /**
     * 普通用户
     * 根据id查找用户，跳转到修改信息界面
     * @param id
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.GET)
    public String update(@PathVariable("id") int id ,Model model)  {
       try{
           User user = userService.queryUserById(id);
           model.addAttribute("user",user);
           return "update_common_user";
       } catch (SSException e) {
           LogClerk.errLog.error(e);
           sendErrMsg(e.getMessage());
           return ADMIN_SYS_ERR_PAGE;
       }
    }


    /**
     * 处理修改信息页面
     * @param user
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(value = "doUpdate" ,method = RequestMethod.POST)
    public String doUpdate( User user, @RequestParam("password2") String password2,RedirectAttributes redirectAttributes ,Model model){
        if (Assert.isNull(user.getPassword())||Assert.isNull(password2)) {
            redirectAttributes.addFlashAttribute("message", "密码为空，请重新修改！！！");
            return "redirect:/user/update/"+user.getId();
        }
        try {
            User user1 = userService.queryUserByName(user.getUsername());
            if (user.getPassword().equals(password2)) {
                userService.updateUser(user);
                redirectAttributes.addFlashAttribute("message", "密码修改成功，请重新登录！！！");
                model.addAttribute("user",user);
                return "redirect:/user/login";
            }
         else {
                redirectAttributes.addFlashAttribute("message", "两次密码输入不一致，请重新修改！！！");
                return "redirect:/user/update/"+user.getId();

            }
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     *管理员和超级管理员管理用户
     * 返回全部用户和登录者的等级
     * @param status
     * @param model
     * @return
     */

    @RequestMapping(value = "/administration/{status}" ,method = RequestMethod.GET)
    public String administration(@PathVariable("status") int status ,Model model ) {
     try{
         List<User> userList = userService.listAll();
         model.addAttribute("userList" ,userList);
         model.addAttribute("userStatus",status);
         return "user_main";
     } catch (SSException e) {
         LogClerk.errLog.error(e);
         sendErrMsg(e.getMessage());
         return ADMIN_SYS_ERR_PAGE;
     }

    }


    /**
     * 删除用户，返回用户列表
     * @param id
     * @param Status
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}/{userStatus}" ,method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id , @PathVariable("userStatus") int Status ,RedirectAttributes redirectAttributes ){
        try{
            userService.deleteUser(id);
            redirectAttributes.addAttribute("Status" ,Status);
            return "redirect:/user/administration/"+Status;
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 超级管理员修改用户信息
     * @param id
     * @param userStatus
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}/{userStatus}",method = RequestMethod.GET)
      public String update(@PathVariable("id") int id ,@PathVariable("userStatus") int userStatus ,RedirectAttributes redirectAttributes ,Model model){
       try{
           User user = userService.queryUserById(id);
           model.addAttribute("user",user);
           redirectAttributes.addAttribute("userStatus" ,userStatus);
           return "update_alluser";
       } catch (SSException e) {
           LogClerk.errLog.error(e);
           sendErrMsg(e.getMessage());
           return ADMIN_SYS_ERR_PAGE;
       }
    }


    /**
     * 超级管理员修改用户信息
     * @param Status
     * @param user
     * @return
     */
    @RequestMapping(value = "/ManagerDoUpdate"  ,method = RequestMethod.POST)
    public String doUpdate(@RequestParam("userStatus") int Status ,User user){
        try{
            userService.updateUser(user);
            return "redirect:/user/administration/"+Status;

        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    /**
     * 跳转到主页
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/qq/{id}" ,method = RequestMethod. GET)
    public String qq(Model model, @PathVariable("id") int id, HttpSession session) {
      try{
          User user  = userService.queryUserById(id);
          List<News> list = newsService.listAll();
          session.setAttribute("user",user);
          model.addAttribute("list",list);
          return "main";
      } catch (SSException e) {
          LogClerk.errLog.error(e);
          sendErrMsg(e.getMessage());
          return ADMIN_SYS_ERR_PAGE;
      }
    }
}
