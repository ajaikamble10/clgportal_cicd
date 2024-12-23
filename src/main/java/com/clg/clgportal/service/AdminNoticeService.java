package com.clg.clgportal.service;

import java.util.List;

import com.clg.clgportal.dto.AdminNoticeDto;

public interface AdminNoticeService {
    public AdminNoticeDto addNotice();
    public AdminNoticeDto updateNotice(AdminNoticeDto noticeDto,long id);
    public void deleteNotice(long id);
    public AdminNoticeDto getNoticeById(long id);
    public List<AdminNoticeDto> getAllNotices();
}
