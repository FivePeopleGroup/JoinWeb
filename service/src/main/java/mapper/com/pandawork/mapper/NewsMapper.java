package com.pandawork.mapper;

import com.pandawork.common.entity.Member;
import com.pandawork.common.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 新闻Mapper层
 * (增加新闻，删除新闻，更新新闻，
 * 根据id查询新闻内容，根据关键字查询新闻列表，
 * 新闻列表)
 * Created by 侯淑婷 on 2017/8/10.
 */
public interface NewsMapper {


    /**
     * 增加新闻
     * @param news news
     * @throws Exception 异常
     */
    public void addNews(@Param("news") News news) throws Exception;


    /**
     * 删除新闻
     * @param id id
     * @return 返回
     * @throws Exception 异常
     */
    public boolean deleteNews(@Param("id")int id) throws Exception;


    /**
     * 更新新闻
     * @param news news
     * @throws Exception 异常
     */
    public void updateNews(@Param("news") News news) throws Exception;


    /**
     *根据id查询新闻内容
     * @param id id
     * @return 返回
     * @throws Exception 异常
     */
    public News queryById(@Param("id") int id) throws Exception;


    /**
     * 根据关键字查询新闻列表
     * @param keyWord keyWord
     * @return 返回
     * @throws Exception 异常
     */
    public List<News> queryByKeyWord(@Param("keyWord") String keyWord)throws Exception;


    /**
     * 新闻列表
     * @return 返回
     * @throws Exception 异常
     */
    public List<News> listAll() throws Exception;


}
