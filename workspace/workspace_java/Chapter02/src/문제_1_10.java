import java.util.Scanner;

public class 문제_1_10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("첫번째 수 : ");
    int a = sc.nextInt();
    System.out.println("두번째 수 : ");
    int b = sc.nextInt();
    System.out.println("세번째 수 : ");
    int c = sc.nextInt();

    int min, mid, max;

    //a가 가장 큰 경우
    if(a > b && a > c){
      max = a;
      mid = b > c ? b : c;
      min = b > c ? c : b;
    }
    //b가 가장 큰 경우
    else if(b > a && b > c){
      max = b;
      mid = a > c ? a : c;
      min = a > c ? c : a;
    }
    //그렇지 않으면 (c가 가장 큰 경우)
    else{
      max = c;
      mid = a > b ? a : b;
      min = a > b ? b : a;
    }

    //결과출력
    System.out.println(max + " > " + mid + " > " + min);



  }
}
