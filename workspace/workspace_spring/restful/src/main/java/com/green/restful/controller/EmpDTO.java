package com.green.restful.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmpDTO {
  private String eName;
  private String job;
  private int sal;

  @Override
  public String toString() {
    return "EmpDTO{" +
            "eName='" + eName + '\'' +
            ", job='" + job + '\'' +
            ", sal=" + sal +
            '}';
  }
}
