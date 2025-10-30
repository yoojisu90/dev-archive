package com.green.backend_student.controller;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import com.green.backend_student.service.StuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuController {
  private StuService stuService;

  public StuController(StuService stuService){
    this.stuService = stuService;
  }

  //학급조회
  @GetMapping("/class")
  public List<ClassDTO> getClassInfo(){
    return stuService.getClassInfo();
  }

  //학생조회
  @GetMapping("/students")
  public List<StuDTO> getStuList(){
    ClassDTO classDTO = new ClassDTO();
    return stuService.getStuList(classDTO);
  }

  //학급별 학생조회
  @GetMapping("/students/{classNum}")
  public List<StuDTO> getStuListByClassNum(@PathVariable("classNum")int classNum){
    ClassDTO classDTO = new ClassDTO();
    classDTO.setClassNum(classNum);
    return stuService.getStuList(classDTO);
  }





}
