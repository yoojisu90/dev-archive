package com.green.backend_shop.buy.service;

import com.green.backend_shop.buy.dto.*;
import com.green.backend_shop.buy.mapper.BuyMapper;
import com.green.backend_shop.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyService {
  private final BuyMapper buyMapper;
  private final CartMapper cartMapper;

  //도서 상제 페이지 - 구매하기
  public void insertBuy(BuyDTO buyDTO){
    buyMapper.insertBuy(buyDTO);
  }

  //장바구니 페이지 - 구매하기
  //구매는
  //1. SHOP_BUY 테이블에 INSERT 쿼리와
  //2. SHOP_CART 테이블에 DELETE 쿼리
  //두 쿼리의 실행으로 이루어져 있다.
  //두 쿼리는 둘 다 성공해야 성공으로 판단할 수 있기 때문에
  //Transaction을 사용하여 두 쿼리를 하나의 묶음으로 간주해야 한다.
  //Transactional 어노테이션의 선언된 메서드 내의 모든 쿼리는 하나의 묶음으로 간주함
  // -> 메서드 내 모든 쿼리실행 명령어가 정상 작동 되어야지만 commit을 진행함.
  //rollbackFor : 이 속성에는 어떤 경우에 롤백을 진행할지 설정할 수 있는 속성
  //Exception.class -> 모든 오류에 대해(이유 불문하고) 오류가 발생하면 무조건 롤백 시키겠다
  @Transactional(rollbackFor = Exception.class)
  public void buyAll(BuyDTO buyDTO){
    //SHOP_BUY 테이블에 구매 정보 INSERT
    buyMapper.buyAll(buyDTO);

    //구매한 장바구니 정보는 SHOP_CART 테이블에서 DELETE
    cartMapper.deleteCartAll(buyDTO);
  }

  //구매 내역 조회
  public List<BuyDTOForAdmin> getBuyListForAdmin(SearchBuyDTO searchBuyDTO){
    return buyMapper.getBuyListForAdmin(searchBuyDTO);
  }

  //구매 상세 내역 조회
  public List<BuyDTO> getBuyDetail(int orderNum){
    return buyMapper.getBuyDetail(orderNum);
  }

  //최근 10일간 날짜 조회
  public List<String> getRecentDate(){
    return buyMapper.getRecentDate();
  }

  //10일간 매출 조회
  public List<Integer> getTotalPrice(){
    return buyMapper.getTotalPrice();
  }


}
