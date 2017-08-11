package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Claus on 2017/8/10.
 */

@Table(name = "t_department")
@Entity
public class Department extends AbstractEntity {

    //部门id
    @Id
    public Integer id;

    //部门名
    @Column(name = "department_name")
    public String departmentName;

    //部门简介
    @Column(name = "department_description")
    public String departmentDescription;

//    //联表字段名
//    @Transient
//    private String memberName;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

//    public String getMemberName() {
//        return memberName;
//    }
//
//    public void setMemberName(String memberName) {
//        this.memberName = memberName;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
//                ", memberName='" + memberName + '\'' +
                '}';
    }
}
