import java.util.Scanner;

public class 삼항연산자_연습2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("첫번째 수 : ");
    int a = sc.nextInt();
    System.out.println("두번째 수 : ");
    int b = sc.nextInt();

    int max = a > b ? a : b;
    int min = a > b ? b : a;

  }
}
