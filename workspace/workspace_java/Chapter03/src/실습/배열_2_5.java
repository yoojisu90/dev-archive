package 실습;

public class 배열_2_5 {
  public static void main(String[] args) {

    int[] arr = new int[6];
    for(int i=0; i< arr.length; i++){
      int a=(int)(Math.random()*45+1);
      arr[i]=a;
      System.out.print(arr[i] + " ");
    }

  }
}
