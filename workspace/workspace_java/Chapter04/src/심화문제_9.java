import java.util.Arrays;

public class 심화문제_9 {
  public static void main(String[] args) {
    int[] arr = {10,9,4,56,1,7,8,10};
    int[] result= test9(arr);
    System.out.println(Arrays.toString(result));
  }

  public static int[] test9(int[] arr){
    //매게변수로 들어온 배열의 짝수의 갯수를 구함
    int evenCnt =0;

    for(int i=0; i<arr.length; i++){
      if(arr[i]%2==0){
        evenCnt++;
      }
    }
    //짝수의 갯수만큼의 공간을 갖는 배열을 생성
    int[] resultArr = new int[evenCnt];
    //새로 생성한 배열에 매개변수로 들어온 배열 요소 중 짝수만 저장하낟
    int index = 0;

    for(int i=0; i<arr.length; i++){
      if(arr[i]%2==0){
        /*resultArr[index] = arr[i];
        index++;*/

        resultArr[index++] = arr[i];
      }
    }
    //배열을 리터한다
    return resultArr;
  }
}
