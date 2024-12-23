package com.clg.clgportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clg.clgportal.dto.ApiResponse;
import com.clg.clgportal.dto.SubjectDto;
import com.clg.clgportal.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/")
    public ResponseEntity<SubjectDto> addSubject(@RequestBody SubjectDto subjectDto){
        SubjectDto subject = subjectService.addSubject(subjectDto);
        return new ResponseEntity<>(subject,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id){
        SubjectDto updatedSubject = subjectService.updateSubject(subjectDto, id);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSubject(@PathVariable long id){
        subjectService.deleteSubject(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Subject Deleted.", true),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable long id){
        SubjectDto subject = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<SubjectDto>> getAllSubjects(){
        List<SubjectDto> allSubjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(allSubjects);
    }
}
