package com.green.basic_board2.service;

import com.green.basic_board2.dto.BoardDTO;
import com.green.basic_board2.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
  private BoardMapper boardMapper;

  public BoardService(BoardMapper boardMapper){
    this.boardMapper = boardMapper;
  }

  //게시글 등록 메서드
  public void insertBoard(BoardDTO boardDTO){
    System.out.println("게시글 등록을 시작합니다");
    boardMapper.insertBoard(boardDTO);
    System.out.println("등록 완료!");
  }

  //게시글 수정 메서드
  public int updateBoard(BoardDTO boardDTO){
    //update 쿼리 실행 결과 영향을 받은 행의 갯수
    int result = boardMapper.updateBoard(boardDTO);
    return result;
  }

  //게시글 삭제 메서드
  public int deleteBoard(int boardNum){
    int result = boardMapper.deleteBoard(boardNum);
    return result;
  }

  //게시글 목록 조회 메서드
  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  public BoardDTO getBoardDetail(int boardNum){
    return boardMapper.getBoardDetail(boardNum);
  }

  public List<BoardDTO> searchTitle(String title){
    return boardMapper.searchTitle(title);
  }

}
