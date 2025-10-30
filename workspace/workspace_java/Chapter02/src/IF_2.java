import java.util.Scanner;

public class IF_2 {
  public static void main(String[] args) {
    // 키보드로 정수 하나를 입력받아,
    // 입력받은 정수가 짝수 일때만, "A" 문자열을 출력하세요.
    // 모든 짝수는 2로 나누었을 때 나머지가 0이다.
    Scanner sc = new Scanner(System.in);

    int num;
    System.out.print("숫자 : ");
    num = sc.nextInt();

    if (num % 2 == 0){
      System.out.println("A");
    }






  }
}
