package com.green.car.sales.dto;

import com.green.car.car.dto.CarDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesDTO {
  private int salesNum;
  private String buyer;
  private String phone;
  private String color;
  private LocalDateTime saleDate;
  private int carNum;
  private CarDTO carDTO;
}
