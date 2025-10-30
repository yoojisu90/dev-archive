package com.green.basic_member.service;

import com.green.basic_member.dto.RegFormDTO;
import com.green.basic_member.mapper.RegFormMapper;
import org.springframework.stereotype.Service;

@Service
public class RegFormService {
  private RegFormMapper regFormMapper;

  public RegFormService(RegFormMapper regFormMapper){
    this.regFormMapper = regFormMapper;
  }

  public int insertMember(RegFormDTO regFormDTO){
    return regFormMapper.insertMember(regFormDTO);
  }
}
