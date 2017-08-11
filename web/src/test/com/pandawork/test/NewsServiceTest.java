package com.pandawork.test;

import com.pandawork.common.entity.News;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.NewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * 新闻测试
 * Created by 侯淑婷 on 2017/8/10.
 */
public class NewsServiceTest extends AbstractTestCase {

    @Autowired
    NewsService newsService;

    /**
     * 增加新闻
     * @throws SSException 异常
     */
    @Test
    public void testAddNews() throws SSException{
        News news = new News();
        news.setTitle("侯舒婷宝宝很可爱");
        news.setContent("小可爱一样");
        newsService.addNews(news);
        System.out.println("成功添加！");
    }

    /**
     * 删除新闻
     * @throws SSException 异常
     */
    @Test
    public void testDeleteNews() throws SSException{
        newsService.deleteNews(2);
        System.out.println("删除成功！");
    }

    /**
     * 更新新闻
     * @throws SSException 异常
     */
    @Test
    public void testUpdateNews() throws SSException{
        News news = new News();
        news.setTitle("卓音工作室要纳新啦！");
        news.setContent("主要是招大一新生！");
        news.setId(5);
        newsService.updateNews(news);
        System.out.println("更新成功！");
    }

    /**
     * 根据新闻id查询新闻
     * @throws SSException 异常
     */
    @Test
    public void testQueryById() throws SSException{
        News news = new News();
        news = newsService.queryById(5);
        System.out.println(news);
    }

    /**
     * 根据关键字查询新闻
     * @throws SSException 异常
     */
    @Test
    public void testQueryByKeyWord() throws SSException{
        List<News> list = Collections.emptyList();
        list = newsService.queryByKeyWord("今天");
        System.out.println(list);
    }

    /**
     * 新闻列表
     * @throws SSException 异常
     */
    @Test
    public void testListAll() throws SSException{
        List<News> list = Collections.emptyList();
        list = newsService.listAll();
        System.out.println(list);


    }


}
