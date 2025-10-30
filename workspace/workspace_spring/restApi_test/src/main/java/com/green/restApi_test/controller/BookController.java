package com.green.restApi_test.controller;

import com.green.restApi_test.BookDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
  //1)모든 도서정보를 조회하는 기능을 제공하는 REST API
  @GetMapping("/books")
  public List<BookDTO> getBookAll(){
    List<BookDTO> bookList = new ArrayList<>();
    bookList.add(new BookDTO(1,"자바 기초", "김개발", "자바에 대한 기초를 배울 수 있습니다.", 20000));
    bookList.add(new BookDTO(2,"웹 페이지 제작하기", "윤개발", "웹페이지 제작에 대한 기초를 배울 수 있습니다.", 15000));
    bookList.add(new BookDTO(3,"리액트 따라하기", "박개발", "리엑트에 대한 기초를 배울 수 있습니다.", 30000));
    bookList.add(new BookDTO(4,"동남아 여행", "김여행", "동남아 여행의 정보를 배울 수 있습니다.", 15000));
    bookList.add(new BookDTO(5,"한식 레시피", "이요리", "한식 레시피 종류를 배울 수 있습니다.", 20000));
    return bookList;
  }

  //2)하나의 도서정보를 조회하는 기능을 제공하는 REST API
  @GetMapping("/books/{bookNum}")
  public String getBook(@PathVariable ("bookNum") int bookNum){
    System.out.println("하나의 도서정보 조회 실행~");
    System.out.println("도서번호 : " + bookNum);
    return "도서 조회 성공";
  }

  //3)하나의 도서정보를 등록하는 기능을 제공하는 REST API
  //  (도서등록시 도서명, 저자, 도서내용, 가격정보가필요)
  @PostMapping("/books")
  public String insertBook(@RequestBody BookDTO bookDTO){
    System.out.println("도서 정보 등록 실행~");
    System.out.println(bookDTO);
    return "도서명, 저자, 도서내용, 가격정보 등록 성공";
  }

  //4)하나의 도서정보를 삭제하는 기능을 제공하는 REST API
  @DeleteMapping("/books/{bookNum}")
  public String deleteBook(@PathVariable ("bookNum") int bookNum){
    System.out.println("하나의 도서 정보 삭제 실행~");
    return "도서 삭제 성공";
  }

  //5)하나의 도서정보에서 도서명과 저자, 도서가격을
  //  수정하는 기능을 제공하는 REST API
  @PutMapping("/books/{bookNum}")
  public String updateBook(@PathVariable ("bookNum") int bookNum, @RequestBody BookDTO bookDTO){
    System.out.println("하나의 도서 정보 수정 실행~");
    System.out.println("도서번호 : " + bookNum);
    System.out.println(bookDTO);
    return "도서명과 저자, 도서가격 수정 성공";
  }


}
