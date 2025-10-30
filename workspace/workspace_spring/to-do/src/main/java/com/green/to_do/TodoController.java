package com.green.to_do;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/todo")
public class TodoController {
  private final TodoService todoService;

  @GetMapping("")
  public ResponseEntity<?> getTodoList(){
    try {
      List<TodoDTO> todoList = todoService.getTodoList();
      return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("할 일 목록 조회 중 오류가 발생했습니다");
    }

  }

  @PostMapping("")
  public ResponseEntity<?> addTodo(@RequestBody TodoDTO todoDTO){
    try {
      //제목으로 빈 문자가 전달 됐으면...
      if(todoDTO.getTodoTitle().equals("")){
        //강제로 예외(오류)를 발생시킴
        throw new Exception();
      }

      todoService.addTodo(todoDTO.getTodoTitle());
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }catch (Exception e){
      e.printStackTrace();

      boolean isParamError = todoDTO.getTodoTitle() == null || todoDTO.getTodoTitle().equals("");
      //1. 앱에서 입력한 할 일 제목이 이상할 경우
      return ResponseEntity
              .status(
                isParamError
                ?
                HttpStatus.BAD_REQUEST
                :
                HttpStatus.INTERNAL_SERVER_ERROR
              )
              .body(
                isParamError
                ?
                "입력한 제목 데이터가 정상적이지 않습니다"
                :
                "할 일 등록 기능 실행 중 오류가 발생했습니다"
              );

    }

  }

  @DeleteMapping("/{todoNum}")
  public ResponseEntity<?> deleteTodo(@PathVariable int todoNum){
    try {
      //todoNum이 0 이하면 잘못된 요청
      if(todoNum <= 0){
        //강제로 예외(오류)를 발생시킴
        throw new Exception();
      }

      todoService.deleteTodo(todoNum);
      return ResponseEntity.status(HttpStatus.OK).build();
    }catch (Exception e){
      e.printStackTrace();

      boolean isParamError = todoNum <= 0;
      //1. 앱에서 전달한 할 일 번호가 이상할 경우
      return ResponseEntity
              .status(
                isParamError
                ?
                HttpStatus.BAD_REQUEST
                :
                HttpStatus.INTERNAL_SERVER_ERROR
              )
              .body(
                isParamError
                ?
                "입력한 번호 데이터가 정상적이지 않습니다"
                :
                "할 일 삭제 기능 실행 중 오류가 발생했습니다"
              );
    }
  }

  //수정
  @PutMapping("/{todoNum}")
  public ResponseEntity<?> updateTodo(@PathVariable("todoNum") int todoNum,
                                      @RequestBody TodoDTO todoDTO){
    try {
      todoDTO.setTodoNum(todoNum);
      todoService.updateTodo(todoDTO);
      return ResponseEntity.status(HttpStatus.OK).build();
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 오류 발생");
    }
  }

}
