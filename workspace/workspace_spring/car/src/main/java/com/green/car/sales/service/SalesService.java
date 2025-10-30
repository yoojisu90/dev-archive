package com.green.car.sales.service;

import com.green.car.car.dto.CarDTO;
import com.green.car.car.mapper.CarMapper;
import com.green.car.sales.dto.SalesDTO;
import com.green.car.sales.mapper.SalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
  private final SalesMapper salesMapper;

  //판매 정보 등록
  public void regSales(SalesDTO salesDTO){
    salesMapper.regSales(salesDTO);
  }

  //판매 리스트 조회
  public List<SalesDTO> getSalesList(){
    return salesMapper.getSalesList();
  }


}
