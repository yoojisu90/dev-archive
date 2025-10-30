package com.green.backend_shop.book_category.controller;

import com.green.backend_shop.book_category.dto.BookCategoryDTO;
import com.green.backend_shop.book_category.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/categories")
@RequiredArgsConstructor
@Slf4j
public class BookCategoryController {
  private final BookCategoryService bookCategoryService;

  //카테고리 조회 api
  @GetMapping("")
  public List<BookCategoryDTO> getCategory(){
    log.info("카테고리 목록 조회 실행~");
    return bookCategoryService.getCategory();
  }


}
