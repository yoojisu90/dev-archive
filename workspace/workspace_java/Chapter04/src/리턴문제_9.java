public class 리턴문제_9 {
  public static void main(String[] args) {
    int sum = test(5);
    System.out.println("홀수의 합은 : "+sum);
  }

  public static int test(int a){
    int sum = 0;

    for(int i = 1; i< a +1; i++){
      if(i%2!=0){
        sum = sum+i;
//        System.out.println(i);
      }
    }
    return sum;
  }
}
