import java.util.Scanner;

public class 삼항연산자_연습1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("정수 입력 : ");
    int num = sc.nextInt();

    System.out.println( num % 2 == 0 ? "짝수" : "홀수");
  }
}
