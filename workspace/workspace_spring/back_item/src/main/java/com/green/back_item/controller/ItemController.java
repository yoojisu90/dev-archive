package com.green.back_item.controller;

import com.green.back_item.dto.ItemDTO;
import com.green.back_item.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
  private ItemService itemService;

  public ItemController(ItemService itemService){
    this.itemService = itemService;
  }
  //모든 정보 조회
  @GetMapping("")
  public List<ItemDTO> getItemList(){
    return itemService.getItemList();
  }

  //등록
  @PostMapping("")
  public void regItem(@RequestBody ItemDTO itemDTO){
    itemService.regItem(itemDTO);
  }

  //상세정보조회
  @GetMapping("/{itemNum}")
  public ItemDTO getItem(@PathVariable("itemNum")int itemNum){
    return itemService.getItem(itemNum);
  }

  //게시글삭제
  @DeleteMapping("/{itemNum}")
  public int deleteItem(@PathVariable("itemNum")int itemNum){
    return itemService.deleteItem(itemNum);
  }

  //게시글 수정
  @PutMapping("/{itemNum}")
  public void updateItem(@PathVariable("itemNum") int itemNum,
                         @RequestBody ItemDTO itemDTO){
    itemDTO.setItemNum(itemNum);
    itemService.updateItem(itemDTO);
  }

}
