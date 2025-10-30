package com.green.backend_shop.buy.mapper;

import com.green.backend_shop.buy.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
  //도서 상제 페이지 - 구매하기
  public void insertBuy(BuyDTO buyDTO);

  //장바구니 페이지 - 구매하기
  public void buyAll(BuyDTO buyDTO);

  //구매 내역 조회
  public List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO);

  //구매 살세 내역 조회
  public List<BuyDTO> getBuyDetail(int orderNum);

  //최근 10일간 날짜 조회
  public List<String> getRecentDate();

  //10일간 매출 조회
  public List<Integer> getTotalPrice();


}
