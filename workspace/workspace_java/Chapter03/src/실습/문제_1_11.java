package 실습;

import java.util.Scanner;

public class 문제_1_11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 정수 = ");
    int a = sc.nextInt();
    System.out.print("두번째 정수 = ");
    int b = sc.nextInt();

    //입력받은 두 수에서 큰수와 작은 수를 구분
    int max = a > b ? a : b;
    int min = a > b ? b : a;

    int sum = 0;

    //min : 1, max : 5
    int i = min+1;
    while(i < max){
      sum = sum + i;
      i++;
    }
    System.out.println(sum);

  }
}
