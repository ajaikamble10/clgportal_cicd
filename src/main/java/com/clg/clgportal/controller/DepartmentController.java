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
import com.clg.clgportal.dto.DeptDto;
import com.clg.clgportal.service.DeptService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DeptService deptService;

   @PostMapping("/") 
   public ResponseEntity<DeptDto> addDepartment(@RequestBody DeptDto deptDto){
        DeptDto department = deptService.addDepartment(deptDto);
        return new ResponseEntity<>(department,HttpStatus.OK);
   }

   @PutMapping("/{id}")
   public ResponseEntity<DeptDto> updateDepartment(@RequestBody DeptDto deptDto, @PathVariable long id){
        DeptDto updateDepartment = deptService.updateDepartment(deptDto, id);
        return ResponseEntity.ok(updateDepartment);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable long id){
        deptService.deleteDepartment(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Department deleted.", true),HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<DeptDto> getDepartmentById(@PathVariable long id){
        DeptDto dept = deptService.getDeptById(id);
        return new ResponseEntity<>(dept,HttpStatus.OK);
   }

   @GetMapping("/")
   public ResponseEntity<List<DeptDto>> getAllDepartments(){
        List<DeptDto> allDepartments = deptService.getAllDepartments();
        return ResponseEntity.ok(allDepartments);
   }
}
