package stu;

import java.util.Scanner;

public class Program1 {
  private Program[] programs;
  private int cnt;
  private Scanner sc;

  public Program1(){
    programs = new Program[3];
    cnt = 0;
    sc = new Scanner(System.in);

  }

  //학생 등록기능
  public void regStudent(){
    System.out.println("학생 등록을 시작합니다. 학생 정보를 입력하세요");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("나이 : ");
    int age = sc.nextInt();
    System.out.print("연락처 : ");
    String num = sc.next();
    System.out.print("학점 : ");
    String grade = sc.next();

    //학생 객체 생성
    Program student = new Program(name,age,num,grade);

    programs[cnt] = student;
    cnt++;
  }

  //연락처변경(2번)
  public void setNum(){
    System.out.print("변경 학생 : ");
    String name= sc.next();
    for(int i =0; i<cnt; i++){
      programs[i].setName(name);
    }
    System.out.print("연락처 : ");
    String num = sc.next();
    for(int i =0; i<cnt; i++){
      programs[i].setNum(num);
    }
  }

  //학생정보출력
  public void stuInfo(){
    System.out.print("정보를 열람할 학생 : ");
    String name = sc.next();
    boolean isNotFound = true;
    for(int i =0; i<cnt; i++){
      if(programs[i].getName().equals(name)) {
        isNotFound = false;
        System.out.println("요청하신 학생의 정보입니다");
        programs[i].print();
        break;
      }
    }
    if(isNotFound){
      System.out.println("요청하신 학생의 정보가 없습니다");
    }

  }

  //모든학생 정보출력
  public void stuInfoAll(){
    System.out.println("-- 모든 학생의 정보는 다음과 같습니다 --");
    for(int i =0; i<cnt; i++){
      System.out.print("이름 : "+programs[i].getName()+",");
      System.out.print("나이 : "+programs[i].getAge()+",");
      System.out.println("학점 : "+programs[i].getGrade());

    }
  }





}
