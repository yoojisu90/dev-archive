package com.green.back_item.mapper;

import com.green.back_item.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
  //모든 정보 조회
  public List<ItemDTO> getItemList();
  //등록
  public void regItem(ItemDTO itemDTO);
  //하나 게시글 조회
  public ItemDTO getItem(int itemNum);
  //게시글 삭제
  public int deleteItem(int itemNum);
  //게시글 수정
  public void updateItem(ItemDTO itemDTO);

}

