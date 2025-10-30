public class 심화문제_3 {
  public static void main(String[] args) {
    int ran = test(0);
    System.out.println(ran);
  }

  public static int test(int a){
    int ran = (int)(Math.random()*50+1);
    return ran;
  }
}
