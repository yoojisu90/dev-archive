package 실습;

import java.util.Scanner;

public class 무한루프_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while(true){
      System.out.print("점수를 입력 : ");
      int num = sc.nextInt();

      if(num<101 && num>-1){
        break;
      }
    }
  }
}
