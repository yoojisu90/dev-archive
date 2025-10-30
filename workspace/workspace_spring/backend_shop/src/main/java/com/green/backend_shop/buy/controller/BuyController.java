package com.green.backend_shop.buy.controller;

import com.green.backend_shop.buy.dto.*;
import com.green.backend_shop.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/buys")
public class BuyController {
  private final BuyService buyService;

  //도서 상세페이지 - 구매하기 api
  @PostMapping("")
  public ResponseEntity<?> insertBuy(@RequestBody BuyDTO buyDTO){
    try {
      //실행코드
      buyService.insertBuy(buyDTO);

      return ResponseEntity.status(HttpStatus.CREATED).build();
    }catch(Exception e){
      //오류가 발생하면 실행할 코드
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("구매하기 쿼리 실행 중 오류가 발생했습니다");
    }
  }

  //장바구니 페이지 - 구매하기 api
  @PostMapping("/all")
  public void buyAll(@RequestBody BuyDTO buyDTO){
    System.out.println(buyDTO);
    buyService.buyAll(buyDTO);
  }

  //구매 내역 조회 api - 관리자페이지
  @GetMapping("/buy-list-admin")
  public ResponseEntity<List<BuyDTOForAdmin>> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    System.out.println(searchBuyDTO);

    try {
      //구매 목록
      List<BuyDTOForAdmin> list = buyService.getBuyListForAdmin(searchBuyDTO);
      return ResponseEntity.status(HttpStatus.OK).body(list);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  //구매 상세 내역 조회
  @GetMapping("/buy-list-admin/{orderNum}")
  public List<BuyDTO> getBuyDetail(@PathVariable("orderNum")int orderNum){
    return buyService.getBuyDetail(orderNum);
  }

  //최근 10일간 날짜 조회
  @GetMapping("/recent-date")
  public List<String> getRecentDate(){
    return buyService.getRecentDate();
  }

  //10일간 매출 조회
  @GetMapping("/total-price")
  public List<Integer> getTotalPrice(){
    return buyService.getTotalPrice();
  }


}
