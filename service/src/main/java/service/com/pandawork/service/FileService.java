package com.pandawork.service;
import com.pandawork.common.entity.File;

import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */
public interface FileService {

    /**
     * 增加图像
     * @param file
     * @throws Exception
     */
    public void addImage (File file) throws Exception;


    /**
     * 查看全部图像
     * @return
     * @throws Exception
     */
    public List<File> listAll() throws Exception;
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
    public void updateImage(File file) throws  Exception;

    /**
     * 通过id修改查找图片
     * @param id
     * @throws Exception
     */

    public void queryById(int id)throws Exception;


    public void upload(String path)throws  Exception;

    /**
     * 查看记录条数
     * @return
     * @throws Exception
     */
    public Integer countAll() throws Exception;
}
