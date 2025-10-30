package com.green.basic_board2.service;

import com.green.basic_board2.dto.MemberDTO;
import com.green.basic_board2.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
  private MemberMapper memberMapper;

  public MemberService(MemberMapper memberMapper){
    this.memberMapper = memberMapper;
  }

  public int insertMember(MemberDTO memberDTO){
    return memberMapper.insertMember(memberDTO);
  }

  public String getMemberName(){
    return memberMapper.getMemberName();
  }

  public List<String> getMemberNameAll(){
    List<String> result =  memberMapper.getMemberNameAll();
    return result;
  }

  public List<MemberDTO> getMemberAll(){
    List<MemberDTO> memberList = memberMapper.getMemberAll();
    return memberList;
  }


}
