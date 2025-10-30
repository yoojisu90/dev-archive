package com.green.car.car.mapper;

import com.green.car.car.dto.CarDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
  //차량 등록
  public void insertCar(CarDTO carDTO);

  //차량 리스트 조회
  public List<CarDTO> getCarInfo();

}
