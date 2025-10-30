package com.green.rest_test.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {
  @GetMapping("/class/{name}")
  public String getClass(@PathVariable ("name") String a){
    return "조회 성공";
  }

  @PostMapping("/class")
  public String insertClass(@RequestBody ClassDTO classDTO){
    System.out.println(classDTO);
    return "등록 성공";
  }



}
