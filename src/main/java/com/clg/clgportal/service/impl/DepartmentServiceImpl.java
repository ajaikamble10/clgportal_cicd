package com.clg.clgportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.clgportal.dto.DeptDto;
import com.clg.clgportal.entity.Department;
import com.clg.clgportal.exception.ResourceNotFoundException;
import com.clg.clgportal.repository.DeptRepository;
import com.clg.clgportal.service.DeptService;

@Service
public class DepartmentServiceImpl implements DeptService{

    @Autowired
    DeptRepository deptRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DeptDto addDepartment(DeptDto deptDto) {
        Department dept=new Department();
        dept.setDeptDesc(deptDto.getDeptDesc());
        dept.setStatus(deptDto.getStatus());
        Department newDepartment = deptRepository.save(dept);    
        DeptDto newDeptDto = DepartmentToDto(newDepartment);
        return newDeptDto;
    }

    @Override
    public void deleteDepartment(long id) {
        Department department = deptRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department", "department id", id));
        deptRepository.delete(department);
    }

    @Override
    public List<DeptDto> getAllDepartments() {
        List<Department> departments = deptRepository.findAll();
        List<DeptDto> lst = departments.stream().map(dept->DepartmentToDto(dept)).collect(Collectors.toList());
        return lst;
    }

    @Override
    public DeptDto getDeptById(long id) {
        Department department = deptRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department", "department id", id));
        DeptDto dept = DepartmentToDto(department);
        return dept;
    }

    @Override
    public DeptDto updateDepartment(DeptDto deptDto, long id) {
       Department dept = deptRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department", "department id", id));
       dept.setDeptDesc(deptDto.getDeptDesc());
       dept.setStatus(deptDto.getStatus());
       Department updatedDept = deptRepository.save(dept);
       DeptDto updateDept = DepartmentToDto(updatedDept);
       return updateDept;
    }
    
    public DeptDto DepartmentToDto(Department dept){
        DeptDto deptDto = modelMapper.map(dept, DeptDto.class);
        return deptDto;
    }

    public Department DtoToDepartment(DeptDto deptDto){
        Department dept = modelMapper.map(deptDto, Department.class);
        return dept;
    }
}
