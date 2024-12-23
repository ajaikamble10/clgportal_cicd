package com.clg.clgportal.service;

import java.util.List;

import com.clg.clgportal.dto.SemesterDto;

public interface SemesterService {
    public SemesterDto addSemseter(SemesterDto semDto);
    public SemesterDto updateSemester(SemesterDto semDto,long id);
    public void deleteSemester(long id);
    public SemesterDto getSemesterById(long id);
    public List<SemesterDto> getAllSemesters();
}
