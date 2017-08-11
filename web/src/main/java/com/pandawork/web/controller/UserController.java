package com.pandawork.web.controller;

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
    public String doLogin(Model model, @RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) throws SSException {

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
                model.addAttribute("user", user);
                return "新闻首页";
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


    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.GET)
    public String update(@PathVariable("id") int id){
        return "update_common_user";
    }


}
