package com.pandawork.service;

import com.pandawork.common.entity.News;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * 新闻管理系统
 * NewsService层
 * Created by 侯淑婷 on 2017/8/10.
 */
public interface NewsService {

    /**
     * 增加新闻
     * @param news news
     * @throws SSException 异常
     */
    public void addNews(News news) throws SSException;


    /**
     * 删除新闻
     * @param id id
     * @return 返回
     * @throws SSException 异常
     */
    public boolean deleteNews(int id) throws SSException;


    /**
     * 更新新闻
     * @param news news
     * @throws SSException 异常
     */
    public void updateNews(News news) throws SSException;


    /**
     * 根据id查询新闻内容
     * @param id id
     * @return 返回
     * @throws SSException 异常
     */
    public News queryById(int id) throws SSException;


    /**
     * 根据关键你字查询新闻列表
     * @param keyWord keyWord
     * @return 返回
     * @throws SSException 异常
     */
    public List<News> queryByKeyWord(String keyWord) throws SSException;


    /**
     * 新闻列表
     * @return 返回
     * @throws SSException 异常
     */
    public List<News> listAll() throws SSException;


}
