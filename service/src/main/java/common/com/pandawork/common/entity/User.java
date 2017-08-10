package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户登陆系统
 * newframework
 * Created by chenf on 2017/8/10.
 */

@Table(name = "t_user")
@Entity
public class User extends AbstractEntity {

    //用户id
    @Id
    public Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    //用户等级  0-普通用户；1-普通管理员；2-超级管理员
    private Integer status;


    @Override
    public void setId(Integer id) {
       this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
