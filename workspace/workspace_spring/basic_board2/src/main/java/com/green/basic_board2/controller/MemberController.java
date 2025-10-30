package com.green.basic_board2.controller;

import com.green.basic_board2.dto.MemberDTO;
import com.green.basic_board2.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
  private MemberService memberService;

  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @PostMapping("/forms")
  public void insertMember(@RequestBody MemberDTO memberDTO){
    memberService.insertMember(memberDTO);
  }

  @GetMapping("/test1")
  public String getMemberName(){
    String result = memberService.getMemberName();
    return result;
  }

  @GetMapping("/test2")
  public List<String> getMemberNameAll(){
    List<String> result = memberService.getMemberNameAll();
    return result;
  }

  @GetMapping("/members")
  public List<MemberDTO> getMemberAll(){
    List<MemberDTO> memberList = memberService.getMemberAll();
    return memberList;
  }


}
