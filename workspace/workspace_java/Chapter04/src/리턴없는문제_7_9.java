import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class 리턴없는문제_7_9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    test7("가","나");

    test8(8,9);

    System.out.print("정수 두개를 입력 : ");
    test9(sc.nextInt(), sc.nextInt());

  }

  public static void test7(String a,String b){
    System.out.println(a+b);
  }

  public static void test8(int a,int b){
    System.out.println(a+b);
  }

  public static void test9(int a,int b){
    System.out.println(a+b);
  }





}
