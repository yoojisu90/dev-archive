package 실습;

public class 배열_2_6 {
  public static void main(String[] args) {
    int max = 0;
    int[] arr={1,5,3,8,2};

    //배열의 크기 만큼 반복한다
    //반복하면서 max의 값과 배열의 각 요소의 값의 크기를 비교
    //배열의 각 요소의 값이 max보다 크다면 배열 요소의 갑을 max에 저장한다.

    for(int i=0; i< arr.length; i++){
      if (max < arr[i]) max = arr[i];
    }

    System.out.println("max : " + max);
  }
}
