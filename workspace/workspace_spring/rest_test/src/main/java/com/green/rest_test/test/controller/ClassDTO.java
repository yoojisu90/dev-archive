package com.green.rest_test.test.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClassDTO {
  private String name;
  private int korScore;
  private int engScore;
  private String addr;

  public ClassDTO(){}
  public ClassDTO(String name, int korScore, int engScore, String addr) {
    this.name = name;
    this.korScore = korScore;
    this.engScore = engScore;
    this.addr = addr;
  }

  @Override
  public String toString() {
    return "ClassDTO{" +
            "name='" + name + '\'' +
            ", korScore=" + korScore +
            ", engScore=" + engScore +
            ", addr='" + addr + '\'' +
            '}';
  }
}
