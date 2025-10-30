public class 심화문제_4 {
  public static void main(String[] args) {
    int num = test(3);
    System.out.println(num);
  }

  public static int test(int a){
    int num= a;
    if(num%2==0){
      System.out.println("true");
    }
    else{
      System.out.println("false");
    }
    return num;
  }
}
