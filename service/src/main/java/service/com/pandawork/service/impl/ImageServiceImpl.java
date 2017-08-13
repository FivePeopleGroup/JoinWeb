package com.pandawork.service.impl;

import com.pandawork.common.entity.Image;
import com.pandawork.common.utils.ImageUtil;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.ImageMapper;
import com.pandawork.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
@Autowired
    ImageMapper imageMapper;

    @Autowired
    protected CommonDao commonDao;


    /**
     * 增加图片
     * @param image
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addImage(Image image)  {
       if(Assert.isNull(image)){
           return;
       }
       try{
           imageMapper.addImage(image);
       } catch (Exception e) {
           LogClerk.errLog.error(e);
       }
    }

    /**
     * 全部图片
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public List<Image> listAll() throws Exception {

            List<Image> imageList = new ArrayList<Image>();
            imageList = imageMapper.listAll();
            return  imageList;

    }

    /**
     * 删除图片
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteImage(int id) throws Exception {
         return  imageMapper.deleteImage(id);
    }


    /**
     * 修改图片
     * @param image
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateImage(Image image) throws Exception {
        if (Assert.isNull(image)) {
            return;
        }
        imageMapper.updateImage(image);

    }





    /**
     * 通过id查找
     * @param id
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void queryById(int id) throws Exception {
       if(Assert.lessOrEqualZero(id)){
           return;
       }
         imageMapper.queryById(id);

    }

    @Override
    public void upload(String path) throws Exception {

    }
}
