package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wangh on 2017/8/6.
 */
@Table(name = "t_section")
@Entity
public class Section extends AbstractEntity {
    //模块ID
    @Id
    public Integer id;

    //模块名称
    @Column(name = "section_name")
    private String sectionName;


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}