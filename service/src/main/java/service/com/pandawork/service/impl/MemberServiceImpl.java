package com.pandawork.service.impl;

import com.pandawork.common.entity.Member;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.MemberMapper;
import com.pandawork.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static com.pandawork.core.common.util.Assert.isNull;
import static com.pandawork.core.common.util.Assert.lessOrEqualZero;

/**
 * Created by wangh on 2017/8/10.
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<Member> listAll() throws SSException {
        List<Member> memberList = Collections.emptyList();
        try {
            memberList = memberMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListALLMemberFailed, e);
        }
        return memberList;
    }




    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void addMember(Member member) throws SSException {
        if (isNull(member)) {
            return;
        }
        try {
            memberMapper.addMember(member);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.AddMemberFailed, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteMember(int id) throws SSException {
        if (lessOrEqualZero(id)) {
            return false;
        }
        try {
            return memberMapper.deleteMember(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DeleteMemberFailed, e);
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteMemberByDepartmentId(int departmentId) throws SSException {
        if (lessOrEqualZero(departmentId)) {
            return false;
        }
        try {
            return memberMapper.deleteMemberByDepartmentId(departmentId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DeleteMemberByDepartmentIdFailed, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateMember(Member member) throws SSException {
        if (isNull(member))
            return;
        try {
            memberMapper.updateMember(member);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateMemberFailed, e);
        }
    }

    @Override
    public Member queryMemberById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return memberMapper.queryMemberById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryMemberByIdFailed, e);
        }

    }



}
