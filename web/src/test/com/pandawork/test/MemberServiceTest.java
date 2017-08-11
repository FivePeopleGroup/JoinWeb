package com.pandawork.test; /**
 * Created by wangh on 2017/8/10.
 */

import com.pandawork.common.entity.Member;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.MemberService;
import com.pandawork.test.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 成员管理
 * 测试service页面
 * memberService
 * Created by wangh on 2017/8/10.
 */
public class MemberServiceTest extends AbstractTestCase {

    @Autowired
    MemberService memberService;

    //测试增加成员
    @Test
    public void testAddMember() throws Exception {
        Member member = new Member();
        member.setMemberName("小芳");
        member.setSex("女");
        member.setIntroduce("村花");
        member.setDepartmentId(1);
        memberService.addMember(member);
        System.out.println("添加成功");
    }

    //测试查询成员列表
    @Test
    public void testListAll() throws Exception {
        System.out.print(memberService.listAll());
    }


    //测试删除成员
    @Test
    public void testDeleteNewsById() throws Exception {
        memberService.deleteMember(1);
        System.out.println("删除成功！");
    }

    //测试修改成员
    @Test
    public void testUpdateMember() throws Exception {
        Member member = new Member();
        member.setMemberName("小可爱");
        member.setSex("男");
        member.setIntroduce("超可爱");
        member.setDepartmentId(1);
        member.setId(2);
        memberService.updateMember(member);
        System.out.println("修改成功");
    }

    //测试根据ID查找成员
    @Test
    public void testQueryMemberById() throws Exception {
        Member member = new Member();
        System.out.println(memberService.queryMemberById(2));
    }

    //根据部门id删除成员
    @Test
    public void testDeleteMemberByDepartmentId() throws Exception{
        memberService.deleteMemberByDepartmentId(1);
        System.out.println("删除成功！");
    }


}
