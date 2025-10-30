package com.green.ExamPractice.controller;

import com.green.ExamPractice.dto.BoardDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
  @GetMapping("/boards")
  public List<BoardDTO> getBoard(){
    List<BoardDTO> boardList = new ArrayList<>();
    boardList.add(new BoardDTO(1,"책1","김자바","내용1",10));
    boardList.add(new BoardDTO(2,"책2","이자바","내용2",15));
    boardList.add(new BoardDTO(3,"책3","박자바","내용3",20));
    boardList.add(new BoardDTO(4,"책4","파이썬","내용4",15));
    boardList.add(new BoardDTO(5,"책5","스프링","내용5",15));
    return boardList;
  }

}
