package com.green.back_item.service;

import com.green.back_item.dto.ItemDTO;
import com.green.back_item.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
  private ItemMapper itemMapper;

  public ItemService(ItemMapper itemMapper){
    this.itemMapper = itemMapper;
  }
  //모든 정보 조회
  public List<ItemDTO> getItemList(){
    return itemMapper.getItemList();
  }

  //등록
  public void regItem(ItemDTO itemDTO){
    itemMapper.regItem(itemDTO);
  }

  //하나 게시글 조회
  public ItemDTO getItem(int itemNum){
    return itemMapper.getItem(itemNum);
  }

  //게시글 삭제
  public int deleteItem(int itemNum){
    return itemMapper.deleteItem(itemNum);
  }

  //게시글 수정
  public void updateItem(ItemDTO itemDTO){
    itemMapper.updateItem(itemDTO);
  }
}
