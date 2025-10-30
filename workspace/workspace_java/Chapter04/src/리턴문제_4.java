public class 리턴문제_4 {
  public static void main(String[] args) {
    String str = test("안녕","하세요");
    System.out.println(str);
  }

  public static String test(String a, String b){
    String str= a+b;
    return str;
  }
}
