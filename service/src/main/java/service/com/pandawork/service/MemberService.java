package com.pandawork.service;

import com.pandawork.common.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangh on 2017/8/10.
 */
public interface MemberService {
    /**
     * 增加成员
     * @param member
     * @throws Exception
     */
    public void addMember(Member member) throws Exception;

    /**
     *删除成员
     * @param id
     * @throws Exception
     */
    public boolean deleteMember(int id) throws Exception;

    /**
     *删除部门删成员
     * @param departmentId
     * @throws Exception
     */
    public boolean deleteMemberByDepartmentId(int departmentId) throws Exception;


    /**
     * 修改成员
     * @param member
     * @throws Exception
     */
    public void updateMember(Member member) throws Exception;


    /**
     * 根据id查询成员
     * @param id
     * @return
     * @throws Exception
     */
    public Member queryMemberById(int id) throws Exception;


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
    public List<Member> queryMemberByDepartmentId(int departmentId) throws Exception;


}
