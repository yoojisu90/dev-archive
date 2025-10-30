package com.green.backend_shop.book.mapper;

import com.green.backend_shop.book.dto.BookDTO;
import com.green.backend_shop.book.dto.BookImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  //도서 등록
  public void regBook(BookDTO bookDTO);

  //도서 목록 조회
  public List<BookDTO> getBookList();

  //도서 상세정보 조회
  public BookDTO getBookDetail(int bookNum);

  //도서 이미지 등록
  public void insertImgs(List<BookImgDTO> bookImgList);

  //book 테이블에 등록할 book_num 조회
  public int getNextBookNum();


}
