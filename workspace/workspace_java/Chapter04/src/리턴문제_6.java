public class 리턴문제_6 {
  public static void main(String[] args) {
    String str=test(10);
    System.out.println(str);
  }

  public static String test(int a){
    //문자열 -> 정수
    int result1 = Integer.parseInt("10"); //정수 10
    //정수 -> 문자열
    String result2 = String.valueOf(10); //문자열 "10"

    return a+"";

  }
}
