public class 심화문제_7 {
  public static void main(String[] args) {
    String[] arr={"가","나","다","라"};
    String result = test7(arr);
    System.out.println(result);

  }

  public static String test7(String[] arr){
    String str= "";
    for(int i=0; i<arr.length; i++){
      str = str + arr[i];
    }
    return str;
  }
}
