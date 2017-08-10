package com.pandawork.service.impl;

import com.pandawork.common.entity.News;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.NewsMapper;
import com.pandawork.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static com.pandawork.core.common.util.Assert.*;

/**
 * 12
 * Created by wangh on 2017/8/6.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsMapper newsMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<News> listAll() throws SSException {
        List<News> newsList = Collections.emptyList();
        try {
            newsList = newsMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return newsList;
    }

    @Override
    public int countAll() throws SSException {
        int count;
        try {
            count = newsMapper.countAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountAll, e);
        }
        return count;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void insertNews(News news) throws SSException {
        if (isNull(news)) {
            return;
        }
        try {
            newsMapper.insertNews(news);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteNewsById(int id) throws SSException {
        if (lessOrEqualZero(id)) {
            return false;
        }
        try {
            return newsMapper.deleteNewsById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void update(News news) throws SSException {
        if (isNotNull(news))
            return;
        try {
            newsMapper.update(news);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentFailed, e);
        }
    }

    @Override
    public News selectById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return newsMapper.selectById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryStudentByIdFailed, e);
        }

    }

    @Override
    public News selectByTitle(String title) throws SSException {
        if (Assert.isNull(title)) {
            return null;
        }
        try {
            return newsMapper.selectByTitle(title);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
    }
}
