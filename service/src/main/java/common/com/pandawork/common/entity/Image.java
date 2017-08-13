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
public class Image extends AbstractEntity {

    @Id
    public Integer id;
    //图片名称
     private  String  name;
    //图片时间
    private String date;
   //可见
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
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", visible=" + visible +
                '}';
    }
}
