package com.pandawork.service;

import com.pandawork.common.entity.Department;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * Created by Claus on 2017/8/10.
 */
public interface DepartmentService {

    /**
     * 列出全部部门
     * @return
     * @throws SSException
     */
    public List<Department> listAll() throws SSException;

    /**
     * 增加部门
     * @param department
     * @throws SSException
     */
    public void addDepartment(Department department) throws SSException;

    /**
     * 删除部门
     * @param id
     * @return
     * @throws SSException
     */
    public boolean deleteDepartment(int id) throws SSException;

    /**
     * 更新部门
     * @param department
     * @throws SSException
     */
    public void updateDepartment(Department department) throws SSException;

    /**
     * 根据id查找部门
     * @param id
     * @return
     * @throws SSException
     */
    public Department queryDepartmentById(int id) throws SSException;

    /**
     * 根据部门名查找部门
     * @param department
     * @return
     * @throws SSException
     */
    public List<Department> queryDepartmentByDepartmentId(int id) throws SSException;
}
