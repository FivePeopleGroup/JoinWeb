package com.pandawork.common.utils;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * NFException
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:55
 */
public enum  NFException implements IBizExceptionMes {
    SystemException("系统内部异常", 1),

    UserNameNotNull("用户名不能为空", 10001),
    PasswordNotNull("密码不能为空", 10002),
    ListStudentAll("获取学生列表失败",10003),
    CountAll("获取学生信息数目失败",10004 ),
    StudentNameNotNull("获取学生姓名为空",10005 ),
    StudentNumLessOrEqualZero("学生学号小于零",10006 ),
    SexNotNull( "获取学生性别为空",10007),
    GradeLessOrEqualZero("获取学生年级小于零",10008),
    ClassNumLessOrEqualZero("获取学生年级小于零",10009),
    CollegeNotNull("获取学生学院为空",10010),
    BirthdayNotNull("获取学生生日为空",10011),
    GoodStudentNotNull("获取是否为好学生为空",10012),
    DelStudentNull("删除学生信息失败",10013),
    UpdateStudentFailed("更新学生信息失败",10014),
    UpdateStudentByIdFailed("按照id查询学生信息失败",10016),
    QueryByNameFailed("按照姓名查询学生信息失败",10017 ),
    queryStudentByIdFailed("", 10017),

    ListALLMemberFailed("查询全部成员失败",40001),
    AddMemberFailed("增加成员失败",40002),
    DeleteMemberFailed("删除成员失败",40003),
    UpdateMemberFailed("修改成员信息失败",40004),
    QueryMemberByIdFailed("通过id查找成员失败",40005),
    DeleteMemberByDepartmentIdFailed("通过部门id删除成员失败",400006),
    AddUser("增加用户失败",20001),
    DeleteUser("删除用户失败",20002),
    UpdateUser("更新用户失败",20003),
    QueryUserById("跟据id查找新闻失败",20004),
    QueryUserByName("根据姓名查找id失败",20005),
    ListAllUser("列出全部用户失败",20006),

    NewsNameNotNull("获取新闻标题为空",50005 ),
    dateNotNull( "获取发布时间为空",50007),
    ContentNotNull("获取新闻内容为空",50010),
    DelNewsNull("删除新闻失败",50013),
    UpdateNewsFailed("更新新闻失败",50014),
    QueryByIdFailed("按照id查询新闻失败",50017 ),
    queryNewsByKeyWordFailed("根据关键字查询新闻失败", 50018),
    ListNewsAll("获取新闻列表失败",50003),


    ListAllDepartment("获取部门列表失败",30001),
    AddDepartment("增加部门失败",30002),
    DeleteDepartment("删除部门失败",30003),
    UpdateDepartment("更新部门失败",30004),
    QueryDepartmentById("根据id查找部门失败",30005),
    QueryDepartmentByName("根据部门名查找部门失败",30006)
    ;

    private String msg;

    private Integer code;

    NFException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }


    @Override
    public String getMes() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
