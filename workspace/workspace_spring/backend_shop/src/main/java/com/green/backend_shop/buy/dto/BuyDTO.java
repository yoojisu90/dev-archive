package com.green.backend_shop.buy.dto;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
import com.green.backend_shop.cart.dto.CartDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BuyDTO {
  private int buyNum;
  private int bookNum;
  private String memId;
  private LocalDateTime buyDate;
  private int buyCnt;
  private int orderNum;
  private BookDTO bookDTO;

  //react에서 전달되는 cartNum 목록 데이터(cartNumList)를 받기 위해 선언한 변수
  private List<Integer> cartNumList;
  //구매상세내역 조회 시 데이터를 받아올 변수
  private int totalPrice;

}
