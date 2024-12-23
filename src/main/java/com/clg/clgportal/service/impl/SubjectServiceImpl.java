package com.clg.clgportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.clgportal.dto.SubjectDto;
import com.clg.clgportal.entity.Subject;
import com.clg.clgportal.exception.ResourceNotFoundException;
import com.clg.clgportal.repository.SubjectRepository;
import com.clg.clgportal.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        Subject subject=new Subject();
        subject.setSubjectDesc(subjectDto.getSubjectDesc());
        subject.setStatus(subjectDto.getStatus());
        Subject newSubject = subjectRepo.save(subject);
        SubjectDto subjectToDto = SubjectToDto(newSubject);
        return subjectToDto;
    }

    @Override
    public void deleteSubject(long id) {
        Subject subject = subjectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subject", "subject id", id));
        subjectRepo.delete(subject);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> list = subjectRepo.findAll();
        List<SubjectDto> subjects = list.stream().map(lst->SubjectToDto(lst)).collect(Collectors.toList());
        return subjects;
    }

    @Override
    public SubjectDto getSubjectById(long id) {
        Subject subject = subjectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subject", "subject id", id));
        SubjectDto subjectToDto = SubjectToDto(subject);
        return subjectToDto;
    }

    @Override
    public SubjectDto updateSubject(SubjectDto subjectDto, long id) {
        Subject subject = subjectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subject", "subject id", id));
        subject.setSubjectDesc(subjectDto.getSubjectDesc());
        subject.setStatus(subjectDto.getStatus());
        Subject updatedSubject = subjectRepo.save(subject);
        SubjectDto subjectToDto = SubjectToDto(updatedSubject);
        return subjectToDto;
    }

    public SubjectDto SubjectToDto(Subject subject){
        SubjectDto subjectDto = modelMapper.map(subject, SubjectDto.class);
        return subjectDto;
    }

    public Subject DtoToSubject(SubjectDto subjectDto){
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        return subject;
    }
    
}
