package com.clg.clgportal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.clgportal.dto.AdminNoticeDto;
import com.clg.clgportal.entity.AdminNotice;
import com.clg.clgportal.repository.AdminNoticeRepository;
import com.clg.clgportal.service.AdminNoticeService;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService{

    @Autowired
    AdminNoticeRepository admNoticeRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AdminNoticeDto addNotice() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteNotice(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<AdminNoticeDto> getAllNotices() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AdminNoticeDto getNoticeById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AdminNoticeDto updateNotice(AdminNoticeDto noticeDto, long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public AdminNoticeDto NoticeToDto(AdminNotice admNotice){
        AdminNoticeDto notice = modelMapper.map(admNotice, AdminNoticeDto.class);
        return notice;
    }

    public AdminNotice DtoToNotice(AdminNoticeDto admNoticeDto){
        AdminNotice notice = modelMapper.map(admNoticeDto, AdminNotice.class);
        return notice;
    }
}
