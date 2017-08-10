package com.pandawork.mapper;

import com.pandawork.common.entity.News;
import com.pandawork.common.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 哈哈哈哈哈
 * Created by wangh on 2017/8/6.
 */
public interface NewsMapper {

    /**
     * 查询所有新闻列表
     * @return
     * @throws Exception
     */
    public List<News> listAll( ) throws Exception;

    /**
     * 查询所有新闻记录数目
     * @return
     * @throws Exception
     */
    public Integer countAll() throws Exception;

    /**
     * 根据id查询新闻
     * @param id
     * @return
     * @throws Exception
     */
    public News selectById(@Param("id") int id) throws Exception;

    /**
     * 根据标题查询新闻
     * @param title
     * @return
     * @throws Exception
     */
    public News selectByTitle(@Param("title") String title) throws Exception;

    /**
     * 增加一条新闻
     * @param news
     * @throws Exception
     */
    public void insertNews(@Param("news") News news) throws Exception;

    /**
     * 修改新闻
     * @param news
     * @throws Exception
     */
    public News update(@Param("news") News news) throws Exception;

    /**
     *删除新闻
     * @param id
     * @throws Exception
     */
    public boolean deleteNewsById(@Param("id") int id) throws Exception;

}