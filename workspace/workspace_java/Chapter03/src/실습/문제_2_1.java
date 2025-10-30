package 실습;

public class 문제_2_1 {
  public static void main(String[] args) {
    int i = 1;
    for(i=1; i<11; i++){
      if(i%2==0)
        continue;
      System.out.println(i);
    }
  }
}
