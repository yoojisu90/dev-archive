public class MyMath implements MathUtil{
  @Override
  public boolean isEven(int a, int b, int c) {
    int sum = a+b+c;
    return sum % 2 == 0 && sum % 5 == 0;
  }

  @Override
  public double getSumFromOne(int num) {
    int sum = 0;
    for (int i=1; i<num+1; i++){
      sum = sum+i;
    }
    return sum;
  }

  @Override
  public double getCircleArea(int rad) {
    double a = rad*rad*Math.PI;
    return rad >= 0 ? a : 0;
  }
}
