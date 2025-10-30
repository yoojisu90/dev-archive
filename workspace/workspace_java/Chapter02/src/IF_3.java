import java.util.Scanner;

public class IF_3 {
  public static void main(String[] args) {
    //키보드로 정수 두 개를 입력받아,
    //두 정수의 합이 10 이상이면 "합이 10 이상입니다"를 출력

    Scanner sc = new Scanner(System.in);

    //키보드로 입력받은 두 정수를 저장할 변수
    int a;
    int b;

    System.out.print("A : ");
      a = sc.nextInt();
    System.out.print("B : ");
      b = sc.nextInt();

    if(a+b >= 10){
      System.out.println("합이 10 이상입니다");
    }

  }
}
