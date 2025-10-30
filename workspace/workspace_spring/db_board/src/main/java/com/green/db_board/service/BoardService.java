package com.green.db_board.service;

import com.green.db_board.dto.BoardDTO;
import com.green.db_board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
  private BoardMapper boardMapper;

  public BoardService(BoardMapper boardMapper){
    this.boardMapper = boardMapper;
  }

  //모든 정보 조회 메서드
  public List<BoardDTO> getBoardList(){
    return boardMapper.getBoardList();
  }

  //게시글 등록 메서드
  public void insertBoard(BoardDTO boardDTO){
    boardMapper.insertBoard(boardDTO);
  }

  //게시글 상세 정보 메서드
  public BoardDTO getBoardDetail(int boardNum){
    return boardMapper.getBoardDetail(boardNum);
  }
  //조회수 증가 메서드
  public void updateCnt(int boardNum){
    boardMapper.updateCnt(boardNum);
  }

  //게시글 삭제 메서드
  public int deleteBoard(int boardNum){
    return boardMapper.deleteBoard(boardNum);
  }

  //게시글 수정 메서드
  public void updateBoard(BoardDTO boardDTO){
    boardMapper.updateBoard(boardDTO);
  }
}
