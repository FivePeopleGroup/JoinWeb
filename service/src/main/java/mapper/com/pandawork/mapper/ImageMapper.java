package com.pandawork.mapper;

import com.pandawork.common.entity.Image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.executor.ExecutorException;

import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */
public interface ImageMapper {

    /**
     * 查看全部图像
     * @return
     * @throws Exception
     */
   public List<Image> listAll() throws Exception;

    /**
     * 增加图像
     * @param image
     * @throws Exception
     */
    public void addImage (@Param("image") Image image) throws Exception;

    /**
     * 删除图像
     * @param id
     * @throws Exception
     */
    public boolean deleteImage(@Param("id") int id)throws Exception;


    /**
     * 修改图像
     * @param
     * @throws Exception
     */
    public void updateImage(@Param("image") Image image)throws  Exception;

    /**
     * 通过id修改查找图片
     * @param id
     * @throws Exception
     */

    public void queryById(@Param("id") int id)throws Exception;

}
