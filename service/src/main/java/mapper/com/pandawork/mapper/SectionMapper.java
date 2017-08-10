package com.pandawork.mapper;

import com.pandawork.common.entity.News;
import com.pandawork.common.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangh on 2017/8/6.
 */
public interface SectionMapper {

    /**
     * 查询所有模块列表
     * @return
     * @throws Exception
     */
    public List<Section> listAll( ) throws Exception;

    /**
     * 查询所有模块记录数目
     * @return
     * @throws Exception
     */
    public Integer countAll() throws Exception;

    /**
     * 根据id查询模块
     * @param id
     * @return
     * @throws Exception
     */
    public Section selectSectionById(@Param("id") int id) throws Exception;

    /**
     * 增加一个模块
     * @param section
     * @throws Exception
     */
    public void insertSection(@Param("section") Section section) throws Exception;

    /**
     * 修改模块
     * @param section
     * @throws Exception
     */
    public Section update(@Param("section") Section section) throws Exception;

    /**
     *删除模块
     * @param id
     * @throws Exception
     */
    public boolean deleteSectionById(@Param("id") int id) throws Exception;

}