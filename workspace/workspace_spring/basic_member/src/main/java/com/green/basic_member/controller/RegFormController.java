package com.green.basic_member.controller;

import com.green.basic_member.dto.RegFormDTO;
import com.green.basic_member.mapper.RegFormMapper;
import com.green.basic_member.service.RegFormService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegFormController {
  private RegFormService regFormService;

  public RegFormController(RegFormService regFormService){
    this.regFormService = regFormService;
  }

  @PostMapping("/forms")
  public void insertMember(@RequestBody RegFormDTO regFormDTO){
    regFormService.insertMember(regFormDTO);
  }
}

