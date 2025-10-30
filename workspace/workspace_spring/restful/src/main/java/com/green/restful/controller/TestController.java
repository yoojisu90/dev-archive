package com.green.restful.controller;

import org.springframework.web.bind.annotation.*;

//프로젝트 실행하자마자 TestController testController = new TestController();

@RestController //객체생성 + ???
public class TestController {

  //회원 목록 조회
  @GetMapping("/members")
  public String getMemberList(){
    System.out.println("회원 목록을 조회합니다");
    return "목록 조회 성공";
  }
  //회원 등록
  @PostMapping("/members")
  public String insertMamber(){
    System.out.println("회원 등록 실행~");
    return "등록 성공";
  }
  //회원 수정
  @PutMapping("/members")
  public String updateMember(){
    System.out.println("회원 정보 수정 실행~");
    return "정보 수정 성공";
  }
  //회원 삭제
  @DeleteMapping("/members")
  public String deleteMember(){
    System.out.println("회원 삭제 실행~");
    return "삭제 성공";
  }
}
