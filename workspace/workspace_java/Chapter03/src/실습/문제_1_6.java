package 실습;

public class 문제_1_6 {
  public static void main(String[] args) {
    //1 2 3 4 5 6 7........99 100
    //0. 3의 배수의 갯수를 저장할 변수를 0으로 초기화
    //1. 1~100까지 반복하면서 각각의 숫자가 3의 배수인지 확인한다.
    //2. 3의 배수라면 3의 배수의 갯수를 저장하고 있는 변수의 값을 1 증가시킨다.
    int i=1;
    int cnt=0;
    while(i<101){
      if(i%3==0){
        cnt++;
      }
      ++i;
    }
    System.out.println(cnt);

    int a=1;
    int b=0;
    for(a=1; a<101; ++a){
      if(a%3==0){
        b++;
      }
    }
    System.out.println(b);
  }
}
