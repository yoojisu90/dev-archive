package 실습;

public class 문제_2_3 {
  public static void main(String[] args) {
    int sum = 0;
    for(int i=1; i<21; i++){

      if (i%3==0){
        continue;
      }
      sum = sum+i;

      //System.out.println(sum+" "+i );
    }
    System.out.println(sum);
  }
}
