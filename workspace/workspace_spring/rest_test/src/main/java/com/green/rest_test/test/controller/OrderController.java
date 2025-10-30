package com.green.rest_test.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
  @GetMapping("/orders")
  public List<OrderDTO> getInfoAll(){
    List<OrderDTO> orderList = new ArrayList<>();
    orderList.add(new OrderDTO(101,"데님청바지",15000,2,"김자바"));
    orderList.add(new OrderDTO(102,"맨투맨 반팔 티셔츠",10000,3,"박자바"));
    orderList.add(new OrderDTO(103,"오버핏 니트",25000,2,"홍길동"));
    orderList.add(new OrderDTO(104,"롱 패딩",55000,1,"이순신"));
    orderList.add(new OrderDTO(105,"맨투맨 긴팔 티셔츠",12000,3,"유관순"));
    return orderList;
  }

  @GetMapping("/orders/{productNum}")
  public String getOrder(@PathVariable ("productNum") int a){
    System.out.println("하나의 주문정보 조회 실행~");
    System.out.println("productNum = " + a);
    return "하나의 주문정보 조회 성공";
  }

  @PostMapping("/orders")
  public String insertOrder(@RequestBody OrderDTO orderDTO){
    System.out.println("하나의 주문정보 등록 실행~");
    System.out.println(orderDTO);
    return "하나의 주문정보 등록 성공";
  }

  @DeleteMapping("/orders/{productNum}")
  public String deleteOrder(@PathVariable ("productNum") int a){
    System.out.println("하나의 주문정보 삭제 실행~");
    return "하나의 주문정보 삭제 성공";
  }

  @PutMapping("/orders/{productNum}")
  public String updateOrder(@PathVariable ("productNum") int a, @RequestBody OrderDTO orderDTO){
    System.out.println("하나의 주문정보에서 상품명과 상품가격을 수정 실행~");
    System.out.println("productNum = " + a);
    System.out.println(orderDTO);
    return "상품명과 상품가격 수정 성공";
  }
}
