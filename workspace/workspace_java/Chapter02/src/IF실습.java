import java.util.Scanner;

public class IF실습 {
  public static void main(String[] args) {
    System.out.println("1번.");
    int a = 30;
    int b = 40;
    if(a+b > 50)
      System.out.println("두 수의 합이 50보다 큽니다");
    else
      System.out.println("두 수의 합이 50이하 입니다.");

    System.out.println();
    System.out.println("2번.");
    Scanner sc = new Scanner(System.in);
    System.out.print("정수의 값 : ");
    int abc = sc.nextInt();
    if(abc % 2 == 0)
      System.out.println("짝수입니다.");
    else if(abc % 2 != 0)
      System.out.println("홀수입니다.");
    else
      System.out.println("0입니다.");

    System.out.println();
    System.out.println("3번.");
    System.out.print("num1 : ");
    int num1 = sc.nextInt();
    System.out.print("num2 : ");
    int num2 = sc.nextInt();
    if(num1 > num2)
      System.out.println("a가 큽니다.");
    else if(num1 < num2)
      System.out.println("b가 큽니다.");
    else if(num1 == num2)
      System.out.println("같습니다.");

    System.out.println();
    System.out.println("4번.");
    System.out.print("num4 : ");
    int num4 = sc.nextInt();
    if(num4 % 3 == 0)
      System.out.println("3의 배수입니다");

    System.out.println();
    System.out.println("5번.");
    System.out.print("정수입력하세요 : ");
    int grade = sc.nextInt();
    if(90<grade && grade<=100)
      System.out.println("학점은 A입니다.");
    else if(80<grade)
      System.out.println("학점은 B입니다.");
    else
      System.out.println("학점은 C입니다.");

    System.out.println();
    System.out.println("6번.");
    int num6 = 9;
    if(num6 % 5 != 0)
      System.out.println("5의 배수를 입력하세요");

    System.out.println();
    System.out.println("7번.");
    System.out.println("B");

    System.out.println();
    System.out.println("8번.");
    System.out.println("A, B, D, H");

    System.out.println();
    System.out.println("9번.");
    System.out.print("첫번째 수 : ");
      int bbb = sc.nextInt();
    System.out.print("두번째 수 : ");
      int ccc = sc.nextInt();
    if(bbb>ccc)
      System.out.println(bbb + " > " + ccc );
    else
      System.out.println(ccc + " > " + bbb);

    System.out.println();
    System.out.println("10번.");
    System.out.print("첫번째 수 : ");
      int x = sc.nextInt();
    System.out.print("두번째 수 : ");
      int y = sc.nextInt();
    System.out.print("세번째 수 : ");
      int z = sc.nextInt();
    if(x > y && y > z && x > z)
      System.out.println(x + " > " + y + " > " + z);
    else if(x > y && z > y && x > z)
      System.out.println(x + " > " + z + " > " + y);
    else if(y > x && x > z && y > z)
      System.out.println(y + " > " + x + " > " + z);
    else if(y > x && z > x && y > z)
      System.out.println(y + " > " + z + " > " + x);
    else if(z > x && x > y && z > y)
      System.out.println(z + " > " + x + " > " + y);
    else if(z > x && y > x && z > y)
      System.out.println(z + " > " + y + " > " + x);
  }
}
