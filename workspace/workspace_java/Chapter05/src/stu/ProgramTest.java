package stu;

import java.util.Scanner;

public class ProgramTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Program1 test = new Program1();

    System.out.println("학생 등록을 시작합니다. 학생 정보를 입력하세요");

    while(true) {
      System.out.print("1)학생등록 ");
      System.out.print("2)학생정보변경(연락처) ");
      System.out.print("3)학생정보출력 ");
      System.out.print("4)모든학생정보출력 ");
      System.out.print("5)프로그램 종료 : ");
      int a = sc.nextInt();
      if(a==1){
        test.regStudent();
      }
      if(a==2){
        test.setNum();
      }
      if(a==3){
        test.stuInfo();
      }
      if(a==4){
        test.stuInfoAll();
      }

      if(a==5){
        System.out.println("프로그램을 종료합니다.");
        break;
      }
    }

  }
}
