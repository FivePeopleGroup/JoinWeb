package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */
@Table(name = "t_image")
@Entity
public class File extends AbstractEntity {

    @Id
    public Integer id;

    //图片名称
    @Column(name="name")
     private  String  name;

    //图片时间
    @Column(name ="date")
    private String date;

    //可见
    @Column(name = "visible")
    private Integer visible;

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    @Override
    public void setId(Integer integer) {
      this.id =  integer;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", visible=" + visible +
                '}';
    }
}
