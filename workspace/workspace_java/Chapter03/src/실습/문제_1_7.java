package 실습;

public class 문제_1_7 {
  public static void main(String[] args) {
    int i=1;
    int cnt=0;
    while(i<101){
      if(i%5==0){
        System.out.print(i + " ");
        cnt++;
      }
      ++i;
    }
    System.out.println("5의 배수인 수의 개수 = "+cnt);

    int a=1;
    int b=0;
    for(a=1; a<101; a++){
      if(a%5==0){
        System.out.print(a + " ");
        b++;
      }
    }
    System.out.println("5의배수갯수 = "+b);
  }
}
