package com.green.basic_board2.controller;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
  private BoardService boardService;

  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  //게시글 등록 API
  @PostMapping("")
  public void regBoard(@RequestBody BoardDTO boardDTO){
    System.out.println("게시글 등록 API 호출");
    System.out.println(boardDTO);
    boardService.insertBoard(boardDTO);
  }

  //게시글 수정 API
  @PutMapping("/{boardNum}")
  public int updateBoard(@PathVariable("boardNum") int boardNum,
                          @RequestBody BoardDTO boardDTO){
    System.out.println("boardNum = " + boardNum);
    System.out.println(boardDTO);

    //boardDTO에 boardNum 값을 넣어줘야 함
    boardDTO.setBoardNum(boardNum);

    int result = boardService.updateBoard(boardDTO);
    return result;
  }

  //게시글 삭제 API
  @DeleteMapping("/{boardNum}")
  public int deleteBoard(@PathVariable("boardNum") int boardNum){
    int result = boardService.deleteBoard(boardNum);
    return result; //삭제된 행의 갯수
  }

  //게시글 목록 조회 API
  @GetMapping("")
  public List<BoardDTO> getBoardList(){
    return boardService.getBoardList();
  }

  //상세조회
  @GetMapping("/{boardNum}")
  public BoardDTO getDetail(@PathVariable("boardNum")int boardNum){
    BoardDTO result = boardService.getBoardDetail(boardNum);
    System.out.println(result);
    return result;
  }

  //제목 검색
  @GetMapping("/search/{title}")
  public List<BoardDTO> searchTitle(@PathVariable("title") String title){
    List<BoardDTO> result = boardService.searchTitle(title);
    System.out.println(result);
    return result;
  }


}
