package com.pandawork.service.impl;

import com.pandawork.common.entity.News;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.NewsMapper;
import com.pandawork.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 新闻管理系统
 * (增加新闻,删除新闻,更新新闻内容,
 * 根据id查询新闻内容,根据关键字查询新闻列表,
 * 新闻列表)
 * NewsServiceImpl层
 * Created by 侯淑婷 on 2017/8/10.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsMapper newsMapper;

    /**
     * 增加新闻
     * @param news news
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addNews(News news) throws SSException {
        if(Assert.isNull(news)){
            return;
        }
        Assert.isNotNull(news.getTitle(), NFException.NewsNameNotNull);
        Assert.isNotNull(news.getContent(), NFException.ContentNotNull);
        try{
            newsMapper.addNews(news);
        }catch(Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException,e);
        }
    }


    /**
     * 删除新闻
     * @param id id
     * @return 返回
     * @throws SSException 异常
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteNews(int id) throws SSException {
        if(Assert.lessOrEqualZero(id)){
            return false;
        }
        try{
           return newsMapper.deleteNews(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelNewsNull,e);
        }
    }


    /**
     * 更新新闻内容
     * @param news news
     * @throws SSException 异常
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateNews(News news) throws SSException {
        if(Assert.isNull(news)){
            return;
        }
        try{
            newsMapper.updateNews(news);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateNewsFailed);
        }
    }


    /**
     * 根据id查询新闻内容
     * @param id id
     * @return 返回
     * @throws SSException 异常
     */
    @Override
    public News queryById(int id) throws SSException {
        if(Assert.lessOrEqualZero(id)){
            return null;
        }
        try{
            return newsMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByIdFailed);
        }
    }

    /**
     * 根据关键字查询新闻列表
     * @param keyWord keyWord
     * @return 返回
     * @throws SSException 异常
     */
    @Override
    public List<News> queryByKeyWord(String keyWord) throws SSException {
        if(Assert.isNull(keyWord)){
            return null;
        }
        try{
            return newsMapper.queryByKeyWord(keyWord);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryNewsByKeyWordFailed);
        }
    }

    /**
     * 新闻列表
     * @return 返回
     * @throws SSException 异常
     */
    @Override
    public List<News> listAll() throws SSException {
        List<News> newsList = Collections.emptyList();
        try{
            newsList = newsMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListNewsAll);
        }
        return newsList;
    }
}
