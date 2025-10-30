package com.green.car.car.service;

import com.green.car.car.dto.CarDTO;
import com.green.car.car.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarMapper carMapper;

  //차량 등록
  public void insertCar(CarDTO carDTO){
    carMapper.insertCar(carDTO);
  }

  //차량 리스트 조회
  public List<CarDTO> getCarInfo(){
    return carMapper.getCarInfo();
  }

}
