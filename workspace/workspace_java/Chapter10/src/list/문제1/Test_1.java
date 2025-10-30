package list.문제1;

import java.util.ArrayList;
import java.util.List;

public class Test_1 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));

  }
}
