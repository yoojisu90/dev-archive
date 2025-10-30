package 실습;

public class 배열_1_9 {
  public static void main(String[] args) {
    int[] arr1={1,5,7};

    int sum = 0;
    for(int i=0; i< arr1.length; i++){
      sum = sum+arr1[i];
    }
    System.out.println(sum);

    for(int e : arr1){
      sum = sum+e;
    }
    System.out.println(sum);
  }
}
