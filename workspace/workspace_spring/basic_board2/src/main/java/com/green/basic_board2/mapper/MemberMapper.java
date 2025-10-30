package com.green.basic_board2.mapper;

import com.green.basic_board2.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface MemberMapper {
  public int insertMember(MemberDTO memberDTO);

  public String getMemberName();

  public List<String> getMemberNameAll();

  public int getMemberAge();

  public MemberDTO getMember();

  public List<MemberDTO> getMemberAll();

  public List<MemberDTO> getMemberAll2(int memAge);
}
