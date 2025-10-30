package list.문제1;

import java.util.ArrayList;
import java.util.List;

public class Test_10 {
  public static void main(String[] args) {
    List<Test_9> stu = new ArrayList<>();

    stu.add(new Test_9("kim", 80, 70));
    stu.add(new Test_9("lee", 50, 60));
    stu.add(new Test_9("park", 100, 80));

//    for (int i = 0; i < stu.size(); i++) {
//      System.out.println(stu.get(i));
//    }
//    System.out.println();
//
    for (Test_9 student : stu){
      System.out.println(student.toString());
    }
    System.out.println();

//    for (int i = 0; i < stu.size(); i++) {
//      if (stu.get(i).getTotalScore() >= 150) {
//        System.out.println(stu.get(i));
//      }
//    }
//    System.out.println();

    for(Test_9 student : stu){
      if(student.getTotalScore() >= 150){
        System.out.println(student);
      }
    }
    System.out.println();

    int sum = 0;
    for (int i = 0; i < stu.size(); i++) {
      sum = sum + stu.get(i).getTotalScore();
    }
    System.out.println("모든 학생의 평균 점수 : " + sum / stu.size());
    System.out.println();

    Test_9 topStu = stu.get(0);
    for (int i = 0; i < stu.size(); i++) {
      if(stu.get(i).getTotalScore() > stu.get(0).getTotalScore()) {
        topStu = stu.get(i);
        System.out.println("총점이 1등인 학생의 정보 : " + topStu);
      }
    }
  }
}

