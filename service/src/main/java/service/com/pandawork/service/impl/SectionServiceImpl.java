package com.pandawork.service.impl;

import com.pandawork.common.entity.News;
import com.pandawork.common.entity.Section;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.NewsMapper;
import com.pandawork.mapper.SectionMapper;
import com.pandawork.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static com.pandawork.core.common.util.Assert.isNotNull;
import static com.pandawork.core.common.util.Assert.isNull;
import static com.pandawork.core.common.util.Assert.lessOrEqualZero;

/**
 * Created by wangh on 2017/8/6.
 */
@Service("sectionService")
public class SectionServiceImpl implements SectionService{
    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<Section> listAll() throws SSException {
        List<Section> sectionList = Collections.emptyList();
        try {
            sectionList = sectionMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return sectionList;
    }

    @Override
    public int countAll() throws SSException {
        int count;
        try {
            count = sectionMapper.countAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountAll, e);
        }
        return count;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void insertSection(Section section) throws SSException {
        if (isNull(section)) {
            return;
        }
        try {
            sectionMapper.insertSection(section);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteSectionById(int id) throws SSException {
        if (lessOrEqualZero(id)) {
            return false;
        }
        try {
            return sectionMapper.deleteSectionById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void update(Section section) throws SSException {
        if (isNotNull(section))
            return;
        try {
            sectionMapper.update(section);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentFailed, e);
        }
    }

    @Override
    public Section selectSectionById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return sectionMapper.selectSectionById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryStudentByIdFailed, e);
        }

    }


}
