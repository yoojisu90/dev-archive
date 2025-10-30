package com.green.backend_student.service;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import com.green.backend_student.mapper.StuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {
  private StuMapper stuMapper;

  public StuService(StuMapper stuMapper){
    this.stuMapper = stuMapper;
  }

  //학급 조회
  public List<ClassDTO> getClassInfo(){
    return stuMapper.getClassInfo();
  }

  //학생 조회
  public List<StuDTO> getStuList(ClassDTO classDTO){
    return stuMapper.getStuList(classDTO);
  }


}
