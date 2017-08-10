package com.pandawork.service;

import com.pandawork.common.entity.News;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * Created by wangh on 2017/8/6.
 */
public interface NewsService {

    /**
     * 查看全部新闻列表
     * @return
     * @throws SSException
     */
    public List<News> listAll( ) throws SSException;

    /**
     * 查询所有新闻记录数目
     * @return
     * @throws SSException
     */
    public int countAll() throws SSException;

    /**
     * 增加一条新闻
     * @throws SSException
     */
    public void insertNews(News news) throws SSException;

    /**
     * 删除一条新闻
     * @throws SSException
     */
    public boolean deleteNewsById(int id) throws SSException;

    /**
     * 修改新闻
     * @throws SSException
     */
    public void update(News news) throws SSException;


    /**
     * 根据ID查询新闻
     * @param id
     * @return
     * @throws Exception
     */
    public News selectById(int id) throws SSException;

    /**
     * 根据标题查询新闻
     * @param title
     * @return
     * @throws SSException
     */
    public News selectByTitle(String title) throws SSException;
}
