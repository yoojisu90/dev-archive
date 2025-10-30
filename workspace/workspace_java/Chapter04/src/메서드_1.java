//자바 코드는 main 메서드의 첫줄부터 마지막줄을 차례로 실행!
public class 메서드_1 {
  public static void main(String[] args) {
    System.out.println("시작");
    hello();
    System.out.println("종료");
  }

  //"안녕"문자열을 출력하는 기능을 가진 메서드를 정의
  public static void hello(){
    System.out.println("안녕");
  }

}
