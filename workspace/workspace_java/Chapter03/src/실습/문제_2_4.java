package 실습;

public class 문제_2_4 {
  public static void main(String[] args) {
    int sum = 0;

    for(int i=1; i<100; i++){
      sum = sum+i;
      if(sum>51) {
        System.out.println("합 = " + sum + " / 마지막숫자 = " + i);
        break;
      }
    }
  }
}
