package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.*;

/**
 * Created by wangh on 2017/8/10.
 */
@Table(name = "t_member")
@Entity
public class Member extends AbstractEntity {
    //成员ID
    @Id
    public Integer id;

    //成员姓名
    @Column(name = "member_name")
    private String memberName;

    //成员性别
    @Column(name = "sex")
    private String sex;

    //成员介绍
    @Column(name = "introduce")
    private String introduce;

    //成员所属部门id
    @Column(name = "department_id")
    private Integer departmentId;

    @Transient
    private String theDepartmentName;

    public String getTheDepartmentName() {
        return theDepartmentName;
    }

    public void setTheDepartmentName(String theDepartmentName) {
        this.theDepartmentName = theDepartmentName;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", departmentId=" + departmentId +
                ", theDepartmentName='" + theDepartmentName + '\'' +
                '}';
    }
}