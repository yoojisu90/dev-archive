import java.util.Scanner;

public class 문제_2_3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    int num2 = sc.nextInt();
    System.out.print("연산자 : ");
    String str= sc.next();
    if(str.equals("+")){
      System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
    }
    else if(str.equals("-")){
      System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
    }
    else if(str.equals("*")){
      System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
    }
    else if(str.equals("/")){
      System.out.println(num1 + " / " + num2 + " = " + (num1/ (double)num2));
    }
    else
      System.out.println("연산자를 잘못 입력하였습니다.");
  }
}
