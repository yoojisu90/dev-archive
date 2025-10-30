package com.green.car.sales.mapper;

import com.green.car.sales.dto.SalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMapper {
  //판매 정보 등록
  public void regSales(SalesDTO salesDTO);

  //판매 리스트 조회
  public List<SalesDTO> getSalesList();


}
