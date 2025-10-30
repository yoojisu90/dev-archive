package com.green.restApi_test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
  private int bookNum;
  private String bookName;
  private String writer;
  private String bookInfo;
  private int price;

  public BookDTO(){}
  public BookDTO(int bookNum, String bookName, String writer, String bookInfo, int price) {
    this.bookNum = bookNum;
    this.bookName = bookName;
    this.writer = writer;
    this.bookInfo = bookInfo;
    this.price = price;
  }

  @Override
  public String toString() {
    return "BookDTO{" +
            "bookNum=" + bookNum +
            ", bookName='" + bookName + '\'' +
            ", writer='" + writer + '\'' +
            ", bookInfo='" + bookInfo + '\'' +
            ", price=" + price +
            '}';
  }
}
