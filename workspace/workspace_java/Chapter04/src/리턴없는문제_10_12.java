public class 리턴없는문제_10_12 {
  public static void main(String[] args) {
    test10(11);
    test11(10,12);
    test12(5);
  }

  public static void test10(int a){
    if(a%2==0){
      System.out.println("짝수입니다");
    }
    else{
      System.out.println("홀수입니다");
    }
  }

  public static void test11(int a, int b){
    if(a%2==0 && b%2==0){
      System.out.println("두 수는 짝수입니다.");
    }
    else if(a%2==0||b%2==0) {
      System.out.println("한 수만 짝수입니다.");
    }
    else if(a%2 !=0 && b%2 !=0){
      System.out.println("두 수는 홀수입니다.");
    }
  }

  public static void test12(int a){
    int[] b = new int[a];
    for(int i=0; i<b.length+1; i++){
      System.out.println(i);
    }
  }

}
