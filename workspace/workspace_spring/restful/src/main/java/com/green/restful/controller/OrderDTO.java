package com.green.restful.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//DTO(Data Transfer Object) - 데이터를 전송할 때 사용하는 객체
@Getter
@Setter
@ToString
public class OrderDTO {
  private String type;
  private int cnt;
  private String addr;
  private String addrDetail;
  private String request;



}
