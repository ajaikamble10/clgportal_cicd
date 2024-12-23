package com.clg.clgportal.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="notice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="notice_id")
    public long id;
    @Column(name="notice_title",nullable = false)
    public String noticeTitle;
    @Column(name="notice",nullable = false)
    public String noticeMsg;
    @Column(name="creation_date",nullable = false)
    public Date creationDate;
    @Column(name="status",nullable = false)
    public String status; 
}
