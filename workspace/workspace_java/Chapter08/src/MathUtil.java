//아래 제공하는 MathUtil 인터페이스를 구현하는
//MyMath 클래스를 구현하시오!
public interface MathUtil {
  //매개변수로 전달된 세 정수의 합이 짝수이면서,
  //동시에 세 정수의 합이 5의 배수일 경우에만 리턴 true, 다른 경우에는 리턴 false
  public boolean isEven(int a,int b,int c);

  //1부터 매개변수로 받은 정수까지의 합을 리턴
  public double getSumFromOne(int num);

  //매개변수로 넘어오는 반지름을 갖는 원의 넓이를 리턴하는 메서드
  //단, 매개변수로 전달된 반지름이 음수라면 원의 넓이는 0으로 리턴
  public double getCircleArea(int rad);

}
