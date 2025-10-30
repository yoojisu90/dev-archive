public class 리턴문제_8 {
  public static void main(String[] args) {
    double avg= test(3,5,9);
    System.out.println(avg);
  }

  public static double test(int a, int b, int c){
    double avg = (a+b+c)/3.0;
    return avg;
  }
}
