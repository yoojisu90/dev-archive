package com.green.car.sales.controller;

import com.green.car.car.dto.CarDTO;
import com.green.car.sales.dto.SalesDTO;
import com.green.car.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/sales")
public class SalesController {
  private final SalesService salesService;

  //판매 정보 등록
  @PostMapping("")
  public void regSales(@RequestBody SalesDTO salesDTO){
    salesService.regSales(salesDTO);
  }

  //판매 리스트 조회
  @GetMapping("")
  public List<SalesDTO> getSalesList(){
    return salesService.getSalesList();
  }


}
