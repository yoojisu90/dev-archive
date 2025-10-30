package com.green.to_do;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MyBatis Mapper 인터페이스
 * 데이터베이스와의 직접적인 통신을 담당
 * XML 파일에 정의된 SQL 쿼리와 1:1로 매핑됨
 */
@Mapper  // MyBatis의 Mapper 인터페이스임을 명시
public interface TodoMapper {
  
  /**
   * 데이터베이스에서 모든 할 일 목록을 조회
   * @return TODO 테이블의 모든 레코드를 담은 List
   * @see todo-mapper.xml의 getTodoList 쿼리와 연결
   */
  public List<TodoDTO> getTodoList();

  /**
   * 새로운 할 일을 데이터베이스에 추가
   * @param todoTitle 추가할 할 일의 제목
   * @see todo-mapper.xml의 addTodo 쿼리와 연결
   */
  public void addTodo(String todoTitle);

  /**
   * 특정 할 일을 데이터베이스에서 삭제
   * @param todoNum 삭제할 할 일의 고유 번호 (PRIMARY KEY)
   * @see todo-mapper.xml의 deleteTodo 쿼리와 연결
   */
  public void deleteTodo(int todoNum);

  //수정
  public void updateTodo(TodoDTO todoDTO);


}
