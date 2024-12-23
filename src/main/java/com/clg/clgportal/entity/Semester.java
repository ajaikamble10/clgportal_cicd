package com.clg.clgportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_sem")
@NoArgsConstructor
@Getter
@Setter
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sem_id")
    public long id;
    @Column(name="sem_desc")
    public String semDesc;
    @Column(name="status")
    public String status;
}
