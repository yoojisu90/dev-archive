package com.green.restful.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

  //모든 사원 정보를 조회하는 api
  @GetMapping("/emps")
  public String infoAll(){
    System.out.println("모든 사원 정보 실행");
    return "모든 사원 정보 조회 성공";
  }

  //한 명의 사원 정보를 조회하는 api
  @GetMapping("/emps/{empNo}")
  public String infoPerson(@PathVariable ("empNo") int a){
    System.out.println("한 명의 사원 정보 조회 실행");
    return "한 명의 사원 정보 조회 성공";
  }

  //한 명의 사원을 등록하는 api (사원명, 직급, 급여 정보를 등록)
  @PostMapping("/emps")
  public String insertEmp(@RequestBody EmpDTO empDTO){
    System.out.println(empDTO);
    return "사원 등록 성공";
  }

  //한 명의 사원을 삭제하는 api
  @DeleteMapping("/emps/{empNo}")
  public String deleteEmp(@PathVariable ("empNo") int a){
    System.out.println("사원 정보 삭제 실행");
    return "사원 정보 삭제";
  }

  //한 명의 사원 정보를 수정하는 api (직급, 급여를 수정)
  @PutMapping("/emps/{empNo}")
  public String updateEmp(@PathVariable ("empNo") int a, @RequestBody EmpDTO empDTO) {
    System.out.println(empDTO);
    return "정보 수정 성공";
  }
}
