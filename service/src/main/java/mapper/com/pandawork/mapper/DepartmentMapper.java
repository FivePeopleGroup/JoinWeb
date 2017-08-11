package com.pandawork.mapper;

        import com.pandawork.common.entity.Department;
        import com.pandawork.core.common.exception.SSException;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

/**
 * Created by Claus on 2017/8/10.
 */
public interface DepartmentMapper {

    /**
     * 列出全部部门
     * @return
     * @throws SSException
     */
    public List<Department> listAll() throws Exception;

    /**
     * 增加部门
     * @param department
     * @throws SSException
     */
    public void addDepartment(@Param("department") Department department) throws Exception;

    /**
     * 删除部门
     * @param id
     * @return
     * @throws SSException
     */
    public boolean deleteDepartment(@Param("id") int id) throws Exception;

    /**
     * 更新部门
     * @param department
     * @throws SSException
     */
    public Department updateDepartment(@Param("department") Department department) throws Exception;

    /**
     * 根据id查找部门
     * @param id
     * @return
     * @throws SSException
     */
    public Department queryDepartmentById(@Param("id") int id) throws Exception;

    /**
     * 根据部门名查找部门
     * @param department
     * @return
     * @throws SSException
     */
    public List<Department> queryDepartmentByDepartmentId(@Param("id") int id) throws Exception;

    public Department queryDescriptionByName(@Param("departmentName") String departmentName) throws Exception;
}
