package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 新闻实体类
 * Created by 侯淑婷 on 2017/8/10.
 */
@Table(name = "t_news")
@Entity
public class News {

    //新闻id
    @Id
    public Integer id;

    //新闻标题
    @Column(name = "title")
    private String title;

    //新闻发布时间
    @Column(name = "date")
    private String date;

    //新闻内容
    @Column(name = "content")
    private String content;

    //获取新闻id
    public Integer getId() {
        return id;
    }

    //设置新闻id
    public void setId(Integer id) {
        this.id = id;
    }

    //获取新闻标题
    public String getTitle() {
        return title;
    }

    //设置新闻标题
    public void setTitle(String title) {
        this.title = title;
    }

    //获取发布时间
    public String getDate() {
        return date;
    }

    //设置发布时间
    public void setDate(String date) {
        this.date = date;
    }

    //获取新闻内容
    public String getContent() {
        return content;
    }

    //设置新闻内容
    public void setContent(String content) {
        this.content = content;
    }

    //重写news的toString方法
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
