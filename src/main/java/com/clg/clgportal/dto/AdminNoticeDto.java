package com.clg.clgportal.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminNoticeDto {
    public long id;
    public String noticeTitle;
    public String noticeMsg;
    public Date creationDate;
    public String status;
}
