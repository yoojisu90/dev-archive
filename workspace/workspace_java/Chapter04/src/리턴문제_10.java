public class 리턴문제_10 {
  public static void main(String[] args) {
    boolean str = test("가나다라");
    System.out.println(str);
  }

  public static boolean test(String a){
    //return a.length() % 2 == 0 ? true : false;
    return a.length() % 2 == 0;

    /*String str = a;

    if(str.length()%2==0){
      System.out.println("true");
    }
    else{
      System.out.println("false");
    }
    return str;*/
  }
}
