package 실습;

import java.util.Scanner;

public class 배열_2_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("정수 입력 : ");
    int a= sc.nextInt();

    int[] arr = new int[a];
    System.out.println("배열의 길이 : "+arr.length);

    int sum = 0;
    for(int i=0; i< arr.length; i++){
      arr[i] = i+1;
      System.out.print(arr[i]+" ");
      sum = sum+arr[i];
    }
    System.out.println();
    System.out.println("평균 : "+sum/(double)arr.length);


  }
}
