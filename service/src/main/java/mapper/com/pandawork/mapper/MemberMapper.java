package com.pandawork.mapper;

import com.pandawork.common.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangh on 2017/8/10.
 */
public interface MemberMapper {

    /**
     * 增加成员
     * @param member
     * @throws Exception
     */
    public boolean addMember(@Param("member") Member member) throws Exception;

    /**
     *删除成员
     * @param id
     * @throws Exception
     */
    public boolean deleteMember(@Param("id") int id) throws Exception;

    /**
     *删除部门删成员
     * @param departmentId
     * @throws Exception
     */
    public boolean deleteMemberByDepartmentId(@Param("departmentId") int departmentId) throws Exception;


    /**
     * 修改成员
     * @param member
     * @throws Exception
     */
    public void updateMember(@Param("member") Member member) throws Exception;


    /**
     * 根据id查询成员
     * @param id
     * @return
     * @throws Exception
     */
    public Member queryMemberById(@Param("id") int id) throws Exception;


    /**
     * 查询所有成员
     * @return 成员列表
     * @throws Exception 异常
     */
    public List<Member> listAll( ) throws Exception;


    /**
     * 通过部门id查找成员
     * @return
     * @throws Exception
     */
    public List<Member> queryMemberByDepartmentId(@Param("departmentId") int departmentId) throws Exception;

}
