package com.green.basic_member.mapper;

import com.green.basic_member.dto.RegFormDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegFormMapper {
  public int insertMember(RegFormDTO regFormDTO);
}
