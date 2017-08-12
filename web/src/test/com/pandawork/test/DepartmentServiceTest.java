package com.pandawork.test;
import com.pandawork.common.entity.Department;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.DepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Claus on 2017/8/10.
 */
public class DepartmentServiceTest extends AbstractTestCase {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void testListAll() throws SSException {
        System.out.println(departmentService.listAll());
    }

    @Test
    public void testAddDepartment() throws SSException{
        Department department = new Department();
        department.setDepartmentName("前端");
        department.setDepartmentDescription("这是啊啊的部门");
        departmentService.addDepartment(department);
        System.out.println("添加成功！");
    }

    @Test
    public void testDeleteDepartment() throws SSException{
        departmentService.deleteDepartment(4);
    }

    @Test
    public void testUpdateDepartment() throws SSException{
        Department department = new Department();
        department.setId(9);
        department.setDepartmentName("生活部");
        department.setDepartmentDescription("这是一个只有学生会才有的部门");
        departmentService.updateDepartment(department);
        System.out.println("更新成功！");
    }

    @Test
    public void testQueryDepartmentById() throws SSException{
        System.out.println(departmentService.queryDepartmentById(1));
    }

    @Test
    public void testQueryDepartmentByDepartmentId() throws SSException{
        System.out.println(departmentService.queryDepartmentByDepartmentId(1));
    }
}
