package list.문제1;

import java.util.ArrayList;
import java.util.List;

public class Test_4 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    for (int i=0; i<10; i++){
      int a = (int)(Math.random()*100)+1;
      list.add(a);
      System.out.print(list.get(i) + " ");
    }
    System.out.println();

    int cnt = 0 ;
    for (int i =0; i<10; i++){
      if(list.get(i) % 2 == 0){
        cnt++;
        System.out.print(list.get(i) + " ");
      }
    }
    System.out.println("짝수의 갯수 : " + cnt);



  }
}
