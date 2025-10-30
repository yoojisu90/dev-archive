package 실습;

public class 배열_2_7 {
  public static void main(String[] args) {

    int[] arr=new int[10];


    for(int i=0; i< arr.length; i++) {
      arr[i] = (int)(Math.random() * 100 + 1);
      System.out.print(arr[i] + " ");
    }

    int min =arr[0];
    int max =arr[0];

    for(int i=0; i< arr.length; i++){
      if (min>arr[i])
        min = arr[i];
      if (max<arr[i])
        max = arr[i];
    }

    System.out.println();
    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);

  }
}
