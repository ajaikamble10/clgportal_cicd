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
import com.clg.clgportal.dto.SemesterDto;
import com.clg.clgportal.service.SemesterService;

@RestController
@RequestMapping("/api/semester")
public class SemesterContoller {

    @Autowired
    private SemesterService semServ;

    @PostMapping("/")
    public ResponseEntity<SemesterDto> addSemester(@RequestBody SemesterDto semDto) {
        SemesterDto semseter = semServ.addSemseter(semDto);
        return new ResponseEntity<>(semseter, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemesterDto> updateSemester(@RequestBody SemesterDto semDto, @PathVariable long id) {
        SemesterDto updateSemester = semServ.updateSemester(semDto, id);
        return ResponseEntity.ok(updateSemester);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSemester(@PathVariable long id) {
        semServ.deleteSemester(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Semester deleted.", true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable long id) {
        SemesterDto semester = semServ.getSemesterById(id);
        return new ResponseEntity<>(semester, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<SemesterDto>> getAllSemesters() {
        List<SemesterDto> allSemesters = semServ.getAllSemesters();
        return ResponseEntity.ok(allSemesters);
    }
}
