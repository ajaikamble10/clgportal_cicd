package com.clg.clgportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.clgportal.dto.SemesterDto;
import com.clg.clgportal.entity.Semester;
import com.clg.clgportal.exception.ResourceNotFoundException;
import com.clg.clgportal.repository.SemesterRespository;
import com.clg.clgportal.service.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    SemesterRespository semRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public SemesterDto addSemseter(SemesterDto semDto) {
        Semester sem=new Semester();
        sem.setSemDesc(semDto.getSemDesc());
        sem.setStatus(semDto.getStatus());
        Semester newSemester = semRepo.save(sem);
        SemesterDto semesterToDto = semesterToDto(newSemester);
        return semesterToDto;
    }

    @Override
    public void deleteSemester(long id) {
       Semester semester = semRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Semester", "semester id", id));
       semRepo.delete(semester); 
    }

    @Override
    public List<SemesterDto> getAllSemesters() {
        List<Semester> allSemesters = semRepo.findAll();
        List<SemesterDto> list = allSemesters.stream().map(sem->semesterToDto(sem)).collect(Collectors.toList());
        return list;
    }

    @Override
    public SemesterDto getSemesterById(long id) {
        Semester semester = semRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Semester", "semester id", id));
        SemesterDto semesterToDto = semesterToDto(semester);
        return semesterToDto;
    }

    @Override
    public SemesterDto updateSemester(SemesterDto semDto, long id) {
        Semester semester = semRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Semester", "semester id", id));
        semester.setSemDesc(semDto.getSemDesc());
        semester.setStatus(semDto.getStatus());
        Semester updatedSem = semRepo.save(semester);
        SemesterDto semesterToDto = semesterToDto(updatedSem);
        return semesterToDto;
    }
    
    public SemesterDto semesterToDto(Semester sem){
        SemesterDto semesterDto = modelMapper.map(sem, SemesterDto.class);
        return semesterDto;
    }

    public Semester DtoToSemester(SemesterDto semDto){
        Semester sem = modelMapper.map(semDto, Semester.class);
        return sem;
    }
}
