package list.문제1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();

    int sum = 0;
    for (int i=0; i<5; i++){
      System.out.print("정수 입력 : ");
      list.add(sc.nextInt());
      sum = sum + list.get(i);
    }
    System.out.println("총합 : " + sum);

  }
}
