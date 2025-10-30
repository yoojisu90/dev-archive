package com.green.db_board.mapper;

import com.green.db_board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  //모든 정보 조회
  public List<BoardDTO> getBoardList();

  //게시글 등록
  public void insertBoard(BoardDTO boardDTO);

  //상세 정보 조회
  public BoardDTO getBoardDetail(int boardNum);
  //조회수 증가
  public void updateCnt(int boardNum);

  //게시글 삭제
  public int deleteBoard(int boardNum);

  //게시글 수정
  public void updateBoard(BoardDTO boardDTO);
}
