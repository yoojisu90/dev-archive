package 실습;

public class 문제_1_3 {
  public static void main(String[] args) {
    int num = 2;
    while(num<11){
      System.out.println(num);
      num =num+2;
    }
    /*for(int i =2; i<11; i=i+2){
      System.out.println(i);
    }*/
    for(int i=2; i<11; i++){
      if(i%2==0){
        System.out.println(i);
      }
    }
  }
}
