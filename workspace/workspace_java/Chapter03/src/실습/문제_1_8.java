package 실습;

import java.util.Scanner;

public class 문제_1_8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("정수 입력 : ");
    int i = sc.nextInt();
    int a = 1;
    int cnt = 0;
    while(a<i+1){
      if(a%2==0){
        cnt++;
      }
      ++a;
    }
    System.out.println("짝수의 개수 = " + cnt);

    System.out.print("숫자 입력 : ");
    int x = sc.nextInt();
    int y= 1;
    int z = 0;
    for(y=1; y<x+1; y++){
      if(y%2==0){
        z++;
      }
    }
    System.out.println("갯수 = "+z);
  }
}
