package com.green.to_do;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Todo 비즈니스 로직을 처리하는 Service 클래스
 * Controller와 Mapper 사이의 중간 계층 역할 수행
 */
@Service  // Spring의 Service 컴포넌트로 등록
@RequiredArgsConstructor  // final 필드에 대한 생성자를 자동으로 생성 (의존성 주입)
public class TodoService {
  // TodoMapper 인터페이스를 통해 데이터베이스에 접근
  private final TodoMapper todoMapper;

  /**
   * 할 일 목록을 조회하는 메서드
   * @return 데이터베이스에 저장된 모든 할 일 목록
   */
  public List<TodoDTO> getTodoList(){
    return todoMapper.getTodoList();
  }

  /**
   * 새로운 할 일을 등록하는 메서드
   * @param todoTitle 등록할 할 일의 제목
   */
  public void addTodo(String todoTitle){
    todoMapper.addTodo(todoTitle);
  }

  /**
   * 특정 할 일을 삭제하는 메서드
   * @param todoNum 삭제할 할 일의 번호 (Primary Key)
   */
  public void deleteTodo(int todoNum){
    // Mapper를 통해 데이터베이스에서 해당 번호의 할 일을 삭제
    todoMapper.deleteTodo(todoNum);
  }

  //수정
  public void updateTodo(TodoDTO todoDTO){
    todoMapper.updateTodo(todoDTO);
  }

}
