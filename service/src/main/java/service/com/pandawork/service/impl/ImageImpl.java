package com.pandawork.service.impl;

import com.pandawork.common.entity.Member;
import com.pandawork.common.utils.ImageUtil;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.pandawork.core.common.util.Assert.isNull;

/**
 * Created by wangh on 2017/8/12.
 */
@Service("imageService")
public class ImageImpl {
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addMember(HttpServletRequest request, HttpServletResponse response) throws SSException {
        try {
            ImageUtil.addfile(response,request);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.AddMemberFailed, e);
        }
    }
}
