package com.pandawork.web.controller;

import com.pandawork.common.entity.Department;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

/**
 * Created by Claus on 2017/8/11.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends AbstractController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String departmentList(Model model){
        try{
            List<Department> list = Collections.emptyList();
            list = departmentService.listAll();
            model.addAttribute("departmentList",list);
            return "department_main";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/toAddDepartment", method = RequestMethod.GET)
    public String toAddDepartment(){
        return "toAddDepartment";
    }

    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public String addDepartment(Department department, RedirectAttributes redirectAttributes){
        try{
            departmentService.addDepartment(department);
            redirectAttributes.addFlashAttribute("message","添加成功！");
            return "redirect:/department/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "deleteDepartment/{id}",method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable("id") int id){
        try{
            departmentService.deleteDepartment(id);
            return "redirect:/department/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "toUpdateDepartment/{id}",method = RequestMethod.GET)
    public String toUpdateDepartment(@PathVariable("id") int id,RedirectAttributes redirectAttributes,Model model){
        redirectAttributes.addAttribute("id",id);
        try{
            Department department = departmentService.queryDepartmentById(id);
            model.addAttribute("department",department);
            return "toUpdateDepartment";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "updateDepartment/{id}",method = RequestMethod.POST)
    public String updateDepartment(Department department,@PathVariable("id") int id){
        try{
            if (!Assert.isNotNull(department)){
                return null;
            }
            departmentService.updateDepartment(department);
            return "redirect:/department/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "queryDepartmentById/{id}",method = RequestMethod.GET)
    public String queryDepartmentById(@PathVariable("id") int id,Model model) {
        try{
            Department department = departmentService.queryDepartmentById(id);
            model.addAttribute("department",department);
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
