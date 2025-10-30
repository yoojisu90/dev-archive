package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_2 {
  public static void main(String[] args) {
    Set<Integer> lotto = new TreeSet<>();

    while(true){
      int num = (int)(Math.random()*45+1);
      lotto.add(num);

      if(lotto.size() >= 6){
        break;
      }
    }

    //lotto 데이터 확인
    for(int e : lotto){
      System.out.print(e + " ");
    }
  }
}
