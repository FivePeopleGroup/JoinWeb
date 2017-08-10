package com.pandawork.service;

import com.pandawork.common.entity.Section;
import com.pandawork.core.common.exception.SSException;
import java.util.List;

/**
 * Created by wangh on 2017/8/6.
 */
public interface SectionService {

    /**
     * 查看全部模块列表
     * @return
     * @throws SSException
     */
    public List<Section> listAll( ) throws SSException;

    /**
     * 查询所有模块记录数目
     * @return
     * @throws SSException
     */
    public int countAll() throws SSException;

    /**
     * 增加一个模块
     * @throws SSException
     */
    public void insertSection(Section section) throws SSException;

    /**
     * 删除一条新闻
     * @throws SSException
     */
    public boolean deleteSectionById(int id) throws SSException;

    /**
     * 修改新闻
     * @throws SSException
     */
    public void update(Section section) throws SSException;


    /**
     * 根据ID查询模块
     * @param id
     * @return
     * @throws Exception
     */
    public Section selectSectionById(int id) throws SSException;

//    /**
//     * 根据名字查询模块
//     * @param sectionName
//     * @return
//     * @throws SSException
//     */
//    public Section selectSectionBySectionName(String sectionName) throws SSException;
}

