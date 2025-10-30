import java.util.Scanner;

public class 리턴문제_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("정수 두 개 입력 : ");
    int X= getX(sc.nextInt(), sc.nextInt());
    System.out.println(X);
  }

  public static int getX(int a, int b){
    int X = a*b;
    return X;
  }

}
