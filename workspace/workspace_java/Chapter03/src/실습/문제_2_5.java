package 실습;

public class 문제_2_5 {
  public static void main(String[] args) {
    for(int a=2; a<10; a++) {

      for(int b=1; b<10; b++){

        if(b==10)
          System.out.println(a+"*"+b+"="+a*b);
        break;

      }
    }


  }
}
