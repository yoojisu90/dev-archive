public class 심화문제_6 {
  public static void main(String[] args) {
    int[] arr= {3,8,11,1,0,5,7,9,10};
    int result = test6(arr);
    System.out.println(result);
  }

  public static int test6(int[] arr){
    int max = arr[0];

    for(int i=1; i<arr.length; i++) {
      if(arr[i]>max){
        max=arr[i];
      }
    }
    return max;
  }
}
