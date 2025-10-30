public class 변수_5 {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;

    System.out.println("a, b 두 변수의 값을 스위칭 하기 전");
    System.out.println("a = " + a);
    System.out.println("b = " + b);

    /// ////////////////////////////////////
    int c = a;
    a = b;
    b = c;
    /// ////////////////////////////////////

    System.out.println("a, b 두 변수의 값을 스위칭 하기 후");

    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
}
