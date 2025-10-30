import java.util.Scanner;

public class 심화문제_3_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  System.out.print("첫번째 수 : ");
    int a = sc.nextInt();
  System.out.print("두번째 수 : ");
    int b = sc.nextInt();
  System.out.print("세번째 수 : ");
    int c = sc.nextInt();
  if(a + b > c && a + c > b && b + c > a)
    System.out.println("가능");
  else
    System.out.println("불가능");
  }
}
