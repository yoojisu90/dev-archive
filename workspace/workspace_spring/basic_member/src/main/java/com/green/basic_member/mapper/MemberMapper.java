package com.green.basic_member.mapper;

import org.apache.ibatis.annotations.Mapper;

//객체 생성 + 인터페이스에 쿼리를 실행하는
@Mapper
public interface MemberMapper {
  //등록
  public void insertMember();
  //수정
  public void updateMember();
  //삭제
  public void deleteMember();

}
