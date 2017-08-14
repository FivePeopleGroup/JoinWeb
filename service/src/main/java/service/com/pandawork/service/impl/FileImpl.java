package com.pandawork.service.impl;

import com.pandawork.common.entity.File;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangh on 2017/8/12.
 */
@Service("fileService")
public class FileImpl implements FileService {

    @Autowired
    com.pandawork.mapper.FileMapper FileMapper;

    @Autowired
    protected CommonDao commonDao;

    /**
     * 增加图片
     * @param file
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addImage(File file)  {
        if(Assert.isNull(file)){
            return;
        }
        try{
            FileMapper.addImage(file);
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
    public List<File> listAll() throws Exception {
        List<File> imageList = new ArrayList<File>();
        imageList = FileMapper.listAll();
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
        return  FileMapper.deleteImage(id);
    }


    /**
     * 修改图片
     * @param file
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateImage(File file) throws Exception {
        if (Assert.isNull(file)) {
            return;
        }
        FileMapper.updateImage(file);

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
        FileMapper.queryById(id);

    }

    @Override
    public void upload(String path) throws Exception {

    }

    @Override
    public Integer countAll() throws Exception {
        int count;
        try {
            count = FileMapper.countAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountAll, e);
        }
        return count;
    }
}
