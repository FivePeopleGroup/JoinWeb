package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.Timestamp;
import java.util.Date;

/**
 * hhhhh
 * Created by wangh on 2017/8/6.
 */
@Table(name = "t_news")
@Entity
public class News extends AbstractEntity {
    //新闻ID
    @Id
    public Integer id;

    //新闻标题
    @Column(name = "title")
    private String title;

    //新闻内容
    @Column(name = "content")
    private String content;

    //新闻日期
    @Column(name = "news_date")
    private Timestamp newsDate;

    //新闻模块id
    @Column(name = "section_id")
    private Integer sectionId;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Timestamp newsDate) {
        this.newsDate = newsDate;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}