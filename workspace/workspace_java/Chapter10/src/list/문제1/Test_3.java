package list.문제1;

import java.util.ArrayList;
import java.util.List;

public class Test_3 {
  public static void main(String[] args) {
    List<String> name = new ArrayList<>();
    name.add("홍길동");
    name.add("김길동");
    name.add("이순신");
    name.add("김씨");

    for(int i=0; i<name.size(); i++){
      if(name.get(i).equals("홍길동")){
        System.out.println("해당 이름이 존재합니다.");
        break;
      }
      else{
        System.out.println("해당 이름이 존재하지 않습니다.");
        break;
      }
    }

  }
}
