package com.pandawork.web.controller;

import com.pandawork.common.entity.Department;
import com.pandawork.common.entity.Member;
import com.pandawork.common.entity.News;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangh on 2017/8/11.
 */
@Controller
@RequestMapping("/member")
public class MemberController extends AbstractController {

    /**
     * 跳到增加成员页面
     * @param userstatus
     * @param model
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/toAdd/{userstatus}/{userId}", method = RequestMethod.GET)
    public String toAddMember(@PathVariable("userstatus") int userstatus, Model model, HttpServletRequest request,@PathVariable("userId") int userId) throws SSException {
        String msg = request.getParameter("msg");
        List<Department> list = Collections.emptyList();
        list = departmentService.listAll();
        model.addAttribute("msg",msg);
        model.addAttribute("list",list);
        model.addAttribute("userId",userId);
        model.addAttribute("userstatus",userstatus);
        return "add_member";
    }


    /**
     * 增加成员
     * @param member
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value ="/add/{userstatus}/{userId}", method = RequestMethod.POST)
    public String addMember(@PathVariable("userstatus") int userstatus, Member member, RedirectAttributes redirectAttributes,@PathVariable("userId") int userId) {
        try {
            if(Assert.isNull(member.getMemberName())||Assert.isNull(member.getSex())||Assert.isNull(member.getDepartmentId())||Assert.isNull(member.getIntroduce())){
                redirectAttributes.addAttribute("msg","请填入完整信息！");
                return "redirect:/member/toAdd/" + userstatus + "/" + userId;
            }else {
            memberService.addMember(member);
            return "redirect:/member/list/" + userstatus + "/" + userId;}
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 删除成员
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}/{userstatus}/{userId}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable("id") int id,@PathVariable("userstatus") int userstatus,@PathVariable("userId") int userId) {
        try {
            memberService.deleteMember(id);
            return "redirect:/member/list/"+userstatus+"/"+ userId;
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳到修改成员页面
     * @param id
     * @param model
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/toUpdate/{id}/{userstatus}/{userId}", method = RequestMethod.GET)
    public String toUpdateMember(@PathVariable("id") int id,@PathVariable("userstatus") int userstatus,Model model,HttpServletRequest request,@PathVariable("userId") int userId) throws Exception {
        String msg = request.getParameter("msg");
        List<Department> list = Collections.emptyList();
        list = departmentService.listAll();
        Member member = memberService.queryMemberById(id);
        model.addAttribute("msg",msg);
        model.addAttribute("list",list);
        model.addAttribute("member",member);
        model.addAttribute("userId",userId);
        model.addAttribute("userstatus",userstatus);
        return "update_member";
    }


    /**
     * 修改成员
     * @param member
     * @return
     */
    @RequestMapping(value = "/update/{userstatus}/{userId}", method = RequestMethod.POST)
    public String update(Member member,@PathVariable("userstatus") int userstatus,RedirectAttributes redirectAttributes,@PathVariable("userId") int userId) {
        try {
            if(Assert.isNull(member.getMemberName())||Assert.isNull(member.getSex())||Assert.isNull(member.getDepartmentId())||Assert.isNull(member.getIntroduce())){
                redirectAttributes.addAttribute("msg","请填入完整信息！");
                return "redirect:/member/toUpdate/" + member.getId()+ "/" + userstatus + "/" + userId;
            } else{
            memberService.updateMember(member);
            return "redirect:/member/list/"+userstatus + "/" + userId;
            }
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    /**
     * 列出所有成员
     * @param model
     * @return
     */
    @RequestMapping(value = "/list/{userstatus}/{userId}", method = RequestMethod.GET)
    public String listAll(@PathVariable("userstatus") int userstatus, @PathVariable("userId") int userId , Model model) {
        try {
            List<Member> list = Collections.emptyList();
            list = memberService.listAll();
            model.addAttribute("memberList", list);//此即为foreach循环的item
            model.addAttribute("userstatus",userstatus);
            model.addAttribute("userId",userId);
            return "member_main";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }

//    /**
//     * 模糊查询
//     * @param key
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/indistinct", method = RequestMethod.POST)
//    public String selectByTitle(String key,Model model) {
//        try {
//            List<News> list = Collections.emptyList();
//            list = newsService.selectByTitle(key);
//            model.addAttribute("list", list);//此即为foreach循环的item
//            return "indistinct";
//        } catch (SSException e) {
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }
//
//
//    /**
//     * 根据模块查找新闻
//     * @param sectionId
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/selectBySectionId/{sectionId}", method = RequestMethod.GET)
//    public String selectBySectionId(@PathVariable("sectionId") int sectionId, Model model ) {  //如果通过表单传参，应该用@RequestParam来绑定参数，如果通过路径传参应该用@PathVariable来绑定参数
//        try {
//            List<News> list = Collections.emptyList();
//            list = newsService.selectBySectionId(sectionId);
//            Section section = sectionService.selectSectionById(sectionId);
//            int a = section.getVisible();
//            model.addAttribute("list", list);//此即为foreach循环的item
//            model.addAttribute("sectionId", sectionId);
//            model.addAttribute("ok",a);
//            return "newsList";
//        } catch (SSException e) {
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }
//
//
//    /**
//     * 根据id查找一条新闻
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
//    public String selectById(@PathVariable("id") int id,Model model) {  //如果通过表单传参，应该用@RequestParam来绑定参数，如果通过路径传参应该用@PathVariable来绑定参数
//        try {
//            News news = newsService.selectById(id);
//            model.addAttribute("news", news);
//            return "check";
//        } catch (SSException e) {
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }


}
