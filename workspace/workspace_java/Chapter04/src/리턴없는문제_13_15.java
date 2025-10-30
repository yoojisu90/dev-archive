public class 리턴없는문제_13_15 {
  public static void main(String[] args) {
    test13(2,10);
    System.out.println();
    test14(2,20);
    test15("hello",5);
  }

  public static void test13(int a, int b){
    int max = a>b? a:b;
    int min = a>b? b:a;

    for(int i=min+1; i<max; i++){
      System.out.print(i+" ");
    }
  }

  public static void test14(int a, int b){
    int max = Math.max(a, b);
    int min = Math.min(a, b);

    int cnt=0;

    for(int i=min+1; i<max; i++){
      if(i%5==0){
        cnt++;
      }
    }
    System.out.println("5의 배수 갯수 : "+cnt);
  }

  public static void test15(String a, int b){
    int[] aa = new int[b];

    for(int i=0; i<aa.length; i++){
      System.out.println(a);
    }
  }

}
