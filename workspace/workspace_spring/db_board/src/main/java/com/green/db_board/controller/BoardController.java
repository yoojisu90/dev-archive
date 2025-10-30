package com.green.db_board.controller;

import com.green.db_board.dto.BoardDTO;
import com.green.db_board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
  private BoardService boardService;

  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  //모든 정보 조회
  @GetMapping("")
  public List<BoardDTO> getBoardList(){
    return boardService.getBoardList();
  }

  //게시글 등록
  @PostMapping("")
  public void insertBoard(@RequestBody BoardDTO boardDTO){
    boardService.insertBoard(boardDTO);
  }

  //상세 정보 조회
  @GetMapping("/{boardNum}")
  public BoardDTO getBoardDetail(@PathVariable("boardNum")int boardNum){
    return boardService.getBoardDetail(boardNum);
  }
  //조회수 증가
  @PutMapping("/read-cnt/{boardNum}")
  public void updateCnt(@PathVariable("boardNum")int boardNum){
    boardService.updateCnt(boardNum);
  }

  //게시글 삭제
  @DeleteMapping("/{boardNum}")
  public int deleteBoard(@PathVariable("boardNum")int boardNum){
    return boardService.deleteBoard(boardNum);
  }

  //게시글 수정
  @PutMapping("/{boardNum}")
  public void updateBoard(@PathVariable("boardNum")int boardNum,
          @RequestBody BoardDTO boardDTO){
    boardDTO.setBoardNum(boardNum);
    boardService.updateBoard(boardDTO);
  }

}
