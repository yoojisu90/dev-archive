import java.util.Scanner;

public class 문제 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("국어점수 : ");
    int korScore = sc.nextInt();
    System.out.print("영어점수 : ");
    int engScore = sc.nextInt();
    System.out.print("수학점수 : ");
    int mathScore = sc.nextInt();

    System.out.println("총점 : " + (korScore+engScore+mathScore));
    System.out.println("평균 : " + ((korScore+engScore+mathScore)/(double)3));


  }
}
