package 실습;

import java.util.Scanner;

public class 배열_1_12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] aa = new int[3];//0:국, 1:영, 2:수

    System.out.print("국어점수 : ");
      aa[0] = sc.nextInt();
    System.out.print("영어점수 : ");
      aa[1] = sc.nextInt();
    System.out.print("수학점수 : ");
      aa[2] = sc.nextInt();

    int sum = 0;
    for(int i=0; i< aa.length; i++){
      sum = sum + aa[i];
    }

    System.out.println("총점 : " +sum);
    System.out.println("평균 : "+sum/(double)3);



  }
}
