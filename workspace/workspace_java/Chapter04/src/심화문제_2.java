public class 심화문제_2 {
  public static void main(String[] args) {
   test(10);

  }

  public static void test(int a){
    int num = a;
    for(int i =1; i<=100; i++){
      if(i % num==0){
      System.out.print(i + " ");
      }
    }

  }
}
