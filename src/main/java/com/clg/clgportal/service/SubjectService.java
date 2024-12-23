package com.clg.clgportal.service;

import java.util.List;

import com.clg.clgportal.dto.SubjectDto;

public interface SubjectService {
    public SubjectDto addSubject(SubjectDto subjectDto);
    public SubjectDto updateSubject(SubjectDto subjectDto,long id);
    public void deleteSubject(long id);
    public SubjectDto getSubjectById(long id);
    public List<SubjectDto> getAllSubjects();
}
