package list.문제1;

import java.util.ArrayList;
import java.util.List;

public class Test_6_8 {
  public static void main(String[] args) {
    List<Test_5> list = new ArrayList<>();

    list.add(new Test_5("kkk","123","kim",20));
    list.add(new Test_5("abgaba","456","lee",30));
    list.add(new Test_5("java","789","park",40));

    for (int i=0; i< list.size(); i++){
      System.out.println(list.get(i));
    }

    int sum = 0;
    for(int i=0; i<list.size(); i++){
      sum = sum + list.get(i).getAge();
    }
    System.out.println("나이의 총합 : " + sum );

    for(int i=0; i< list.size(); i++){
      if(list.get(i).getId().equals("java")){
        list.remove(i);
      }
    }
    for(int i=0; i< list.size(); i++){
      System.out.println(list.get(i));
    }




  }
}
