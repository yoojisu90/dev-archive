import java.util.Arrays;

public class 심화문제_8 {
  public static void main(String[] args) {
    int[] a={1,3,5,7,9};
    int[] b={2,4,6,8,10};
    int[] result = test8(a,b);
    System.out.println(Arrays.toString(result));
  }

  public static int[] test8(int[] a,int[] b){
    int[] aa= new int[a.length + b.length];

    for(int i=0; i<a.length; i++){
      aa[i]=a[i];
    }

    for(int i=0; i<b.length; i++){
      aa[i+a.length]=b[i];
    }

    return aa;
  }
}
