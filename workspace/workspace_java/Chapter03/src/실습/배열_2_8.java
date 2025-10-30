package 실습;

public class 배열_2_8 {
  public static void main(String[] args) {
    int[] arr = new int[100];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i];
      boolean num = true;

      if(a==0){
        num = false;
      }
      else{
        for(int j=2; j<a; j++){
          if(a % j ==0){
            num = false;
            break;
          }
        }
      }

      if (num){
        System.out.println(a);
      }
    }
  }
}
