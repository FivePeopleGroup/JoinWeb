package com.pandawork.web.controller;

import com.pandawork.common.entity.Department;
import com.pandawork.common.entity.Member;
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
 * Created by Claus on 2017/8/11.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends AbstractController {

    @RequestMapping(value = "/list/{userstatus}",method = RequestMethod.GET)
    public String departmentList(@PathVariable("userstatus") int userstatus,Model model){
        try{
            List<Department> list = Collections.emptyList();
            list = departmentService.listAll();
            model.addAttribute("departmentList",list);
            model.addAttribute("userstatus",userstatus);
            return "department_main";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }catch (Exception e){
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/toAddDepartment/{userstatus}", method = RequestMethod.GET)
    public String toAddDepartment(@PathVariable("userstatus") int userstatus, Model model, HttpServletRequest request){
        String msg = request.getParameter("msg");
        model.addAttribute("msg",msg);
        model.addAttribute("userstatus",userstatus);
        return "toAddDepartment";
    }

    @RequestMapping(value = "/addDepartment/{userstatus}",method = RequestMethod.POST)
    public String addDepartment(@PathVariable("userstatus") int userstatus,Department department, RedirectAttributes redirectAttributes){
        try{
            if(Assert.isNull(department.getDepartmentName())||Assert.isNull(department.getDepartmentDescription())) {
                redirectAttributes.addAttribute("msg", "请填入完整信息！");
                return "redirect:/department/toAddDepartment/" + userstatus;
            }else{
                departmentService.addDepartment(department);
                return "redirect:/department/list/" + userstatus;
            }
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }catch (Exception e){
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "deleteDepartment/{id}/{userstatus}",method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable("id") int id,@PathVariable("userstatus") int userstatus){
        try{
            departmentService.deleteDepartment(id);
            memberService.deleteMemberByDepartmentId(id);
            return "redirect:/department/list/"+userstatus;
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }catch (Exception e){
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "toUpdateDepartment/{id}/{userstatus}",method = RequestMethod.GET)
    public String toUpdateDepartment(@PathVariable("id") int id,@PathVariable("userstatus") int userstatus,RedirectAttributes redirectAttributes,Model model,HttpServletRequest request){
        redirectAttributes.addAttribute("id",id);
        try{
            String msg = request.getParameter("msg");
            Department department = departmentService.queryDepartmentById(id);
            model.addAttribute("msg",msg);
            model.addAttribute("department",department);
            model.addAttribute("userstatus",userstatus);
            return "toUpdateDepartment";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/updateDepartment/{id}/{userstatus}",method = RequestMethod.POST)
    public String updateDepartment(Department department,@PathVariable("userstatus") int userstatus,@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        try{
            if (Assert.isNull(department)||Assert.isNull(department.getDepartmentName())||Assert.isNull(department.getDepartmentDescription())){
                redirectAttributes.addAttribute("msg","请填入完整信息！");
                return "redirect:/department/toUpdateDepartment/" + department.getId()+ "/" + userstatus;
            }else{
                departmentService.updateDepartment(department);
                return "redirect:/department/list/"+userstatus;
            }
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }catch (Exception e){
            e.printStackTrace();
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "queryDepartmentById/{id}",method = RequestMethod.GET)
    public String queryDepartmentById(@PathVariable("id") int id,Model model) {
        try{
            Department department = departmentService.queryDepartmentById(id);
            List<Member> list = Collections.emptyList();
            list = memberService.queryMemberByDepartmentId(id);
            model.addAttribute("department",department);
            model.addAttribute("memberList",list);
            return "departmentDescription";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

//    @RequestMapping(value = "queryDescriptionByName/{departmentName}",method = RequestMethod.GET)
//    public String queryDescriptionByName(@PathVariable("departmentName") String departmentName,Model model) {
//        try{
//            Department department = departmentService.queryDescriptionByName(departmentName);
//            model.addAttribute("department",department);
//            return "departmentDescription";
//        }catch (Exception e){
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }
}
