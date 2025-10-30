package com.green.basic_member.service;

import com.green.basic_member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  @Autowired
  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  //등록
  public void insertMember(){
    memberMapper.insertMember();
  }

  //수정
  public void updateMember(){
    memberMapper.updateMember();
  }

  //삭제
  public void deleteMember(){
    memberMapper.deleteMember();
  }

}
