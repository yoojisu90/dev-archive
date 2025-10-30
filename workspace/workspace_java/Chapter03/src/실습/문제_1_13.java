package 실습;

public class 문제_1_13 {
  public static void main(String[] args) {
    int i = 1;
    int sum= 0;

    //무한루프

    while(i < 100){
      sum = sum+i;
      if (sum>300){
        System.out.println("sum = " + sum + " / i = " + i);
        break;
      }
      i++;
    }


  }
}
