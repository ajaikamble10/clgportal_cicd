package com.clg.clgportal.service;

import java.util.List;

import com.clg.clgportal.dto.DeptDto;

public interface DeptService {
    public DeptDto addDepartment(DeptDto deptDto);
    public DeptDto updateDepartment(DeptDto deptDto,long id);
    public void deleteDepartment(long id);
    public DeptDto getDeptById(long id);
    public List<DeptDto> getAllDepartments();
}
