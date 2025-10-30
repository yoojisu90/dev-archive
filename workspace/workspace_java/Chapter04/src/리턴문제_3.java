public class 리턴문제_3 {
  public static void main(String[] args) {
    int max=getNum(7,5);
    System.out.println(max);
  }

  public static int getNum(int a, int b){
    int max = Math.max(a,b);
    return max;
  }
}
