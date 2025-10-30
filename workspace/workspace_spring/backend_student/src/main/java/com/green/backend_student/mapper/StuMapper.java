package com.green.backend_student.mapper;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
  //학급 조회
  public List<ClassDTO> getClassInfo();

  //학생 조회
  public List<StuDTO> getStuList(ClassDTO classDTO);



}
