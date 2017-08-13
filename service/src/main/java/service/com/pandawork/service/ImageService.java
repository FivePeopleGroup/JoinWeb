package com.pandawork.service;
import com.pandawork.common.entity.Image;

import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */
public interface ImageService {

    /**
     * 增加图像
     * @param image
     * @throws Exception
     */
    public void addImage (Image image) throws Exception;


    /**
     * 查看全部图像
     * @return
     * @throws Exception
     */
    public List<Image> listAll() throws Exception;
    /**
     * 删除图像
     * @param id
     * @throws Exception
     */
    public boolean deleteImage(int id)throws Exception;


    /**
     * 修改图像
     * @param
     * @throws Exception
     */
    public void updateImage(Image image) throws  Exception;

    /**
     * 通过id修改查找图片
     * @param id
     * @throws Exception
     */

    public void queryById(int id)throws Exception;


    public void upload(String path)throws  Exception;
}
