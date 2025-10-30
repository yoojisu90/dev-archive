package com.green.backend_shop.book_category.service;

import com.green.backend_shop.book_category.dto.BookCategoryDTO;
import com.green.backend_shop.book_category.mapper.BookCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryService {
  private final BookCategoryMapper bookCategoryMapper;

  //카테고리 조회
  public List<BookCategoryDTO> getCategory(){
    return bookCategoryMapper.getCategory();
  }

}
