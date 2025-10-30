package com.green.rest_test.test.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDTO {
  private int productNum;
  private String productName;
  private int price;
  private int cnt;
  private String buyer;

  public OrderDTO(){}
  public OrderDTO(int productNum, String productName, int price, int cnt, String buyer) {
    this.productNum = productNum;
    this.productName = productName;
    this.price = price;
    this.cnt = cnt;
    this.buyer = buyer;
  }

  @Override
  public String toString() {
    return "OrderDTO{" +
            "productNum=" + productNum +
            ", productName='" + productName + '\'' +
            ", price=" + price +
            ", cnt=" + cnt +
            ", buyer='" + buyer + '\'' +
            '}';
  }
}
