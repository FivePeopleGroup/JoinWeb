package com.pandawork.service.impl;

import com.pandawork.common.entity.File;
import com.pandawork.common.utils.ImageUtil;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.FileMapper;
import com.pandawork.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by wangh on 2017/8/12.
 */
@Service("fileService")
public class FileImpl implements FileService {

    @Autowired
    FileMapper FileMapper;

    @Autowired
    protected CommonDao commonDao;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addMember(HttpServletRequest request, HttpServletResponse response) throws SSException {
        try {
            ImageUtil.addfile(response,request);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.AddMemberFailed, e);
        }
    }

    @Override
    public void addImage(File file) throws Exception {

    }

    @Override
    public List<File> listAll() throws Exception {
        return null;
    }

    @Override
    public boolean deleteImage(int id) throws Exception {
        return false;
    }

    @Override
    public void updateImage(File file) throws Exception {

    }

    @Override
    public void queryById(int id) throws Exception {

    }

    @Override
    public void upload(String path) throws Exception {

    }
}
