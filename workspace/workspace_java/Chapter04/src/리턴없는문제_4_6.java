public class 리턴없는문제_4_6 {
  public static void main(String[] args) {
    test4(5,10);
    test5(2,5,10);
    test6(10,3);
  }

  public static void test4(int a, int b){
    System.out.println(a+b);
  }

  public static void test5(int a,int b,int c){
    System.out.println(a*b*c);
  }

  public static void test6(int a, int b){
    System.out.print(a/(double)b+" ");
    System.out.println(a%b);
  }

}
