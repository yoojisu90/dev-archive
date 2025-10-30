package com.green.restful.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  //치킨 주문받기 api
  @PostMapping("/orders")
  public String getOrder(@RequestBody OrderDTO orderDTO){
    System.out.println("주문 접수");
    System.out.println(orderDTO);
    return "주문 성공";
  }



}
