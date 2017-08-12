package com.pandawork.service.impl;

import com.pandawork.common.entity.Department;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.DepartmentMapper;
import com.pandawork.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by Claus on 2017/8/10.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<Department> listAll() throws SSException{
        List<Department> departmentList = Collections.emptyList();
        try{
            departmentList = departmentMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListAllDepartment,e);
        }
        return departmentList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {SSException.class,Exception.class})
    public void addDepartment(Department department) throws SSException{
        if (Assert.isNull(department)){
            return;
        }
        try{
            departmentMapper.addDepartment(department);
        }catch(Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.AddDepartment,e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {SSException.class,Exception.class})
    public boolean deleteDepartment(int id) throws SSException{
        if (Assert.lessOrEqualZero(id)){
            return false;
        }
        try{
            return departmentMapper.deleteDepartment(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DeleteDepartment,e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {SSException.class,Exception.class})
    public void updateDepartment(Department department) throws SSException{
        if (Assert.isNull(department)){
            return;
        }
        try{
            departmentMapper.updateDepartment(department);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateDepartment,e);
        }
    }

    @Override
    public Department queryDepartmentById(int id) throws SSException{
        if (Assert.lessOrEqualZero(id)){
            return null;
        }
        try{
            return departmentMapper.queryDepartmentById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryDepartmentById,e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {SSException.class,Exception.class})
    public List<Department> queryDepartmentByDepartmentId(int id) throws SSException{
        List<Department> departmentList = Collections.emptyList();
        try{
            departmentList = departmentMapper.queryDepartmentByDepartmentId(id);
        }catch(Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryDepartmentByName,e);
        }
        return departmentList;
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {SSException.class,Exception.class})
//    public Department queryDescriptionByName(String departmentName) throws SSException{
//        if (Assert.isNull(departmentName)){
//            return null;
//        }
//        try{
//            return departmentMapper.queryDescriptionByName(departmentName);
//        }catch(Exception e){
//            LogClerk.errLog.error(e);
//            throw SSException.get(NFException.QueryDepartmentByName,e);
//        }
//    }
}
