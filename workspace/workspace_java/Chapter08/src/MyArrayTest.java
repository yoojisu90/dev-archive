import java.util.Arrays;

public class MyArrayTest {
  public static void main(String[] args) {
    ArrayUtil my = new MyArray();

    int[] arr = {1,2,3};
    int[] arr1 = {4,5,6};
    int result1 = my.getSumOfArray(arr);
    System.out.println(result1);

    double result2 = my.getAvgOfArray(arr,arr1);
    System.out.println(result2);

    int[] result3 = my.getArrayOfEven(arr1);
    System.out.println(Arrays.toString(result3));

  }
}
