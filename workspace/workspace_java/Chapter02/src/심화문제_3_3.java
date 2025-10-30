import java.util.Scanner;

public class 심화문제_3_3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("1~99 사이의 정수를 입력하시오>> ");
    int num = sc.nextInt();

    int a = num / 10;
    int b = num % 10;

    String ten = (a ==3 || a ==6 || a ==9 ? "참" : "거짓");
    String one = (b ==3 || b ==6 || b ==9 ? "true" : "false");

    if(ten.equals("참") && one.equals("true"))
      System.out.println("박수짝짝");
    else if(ten.equals("참") || one.equals("true"))
      System.out.println("박수짝");
  }
}
