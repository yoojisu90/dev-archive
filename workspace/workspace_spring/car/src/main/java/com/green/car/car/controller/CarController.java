package com.green.car.car.controller;

import com.green.car.car.dto.CarDTO;
import com.green.car.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/cars")
public class CarController {
  private final CarService carService;

  //차량 등록
  @PostMapping("")
  public void insertCar(@RequestBody CarDTO carDTO){
    carService.insertCar(carDTO);
  }

  //차량 리스트 조회
  @GetMapping("")
  public List<CarDTO> getCarInfo(){
    return carService.getCarInfo();
  }


}
