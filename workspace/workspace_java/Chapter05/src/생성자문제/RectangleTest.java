package 생성자문제;

public class RectangleTest {
  public static void main(String[] args) {
    Rectangle r = new Rectangle();
    Rectangle s = new Rectangle(1,1,2,3);

    r.show();
    s.show();
    System.out.println(s.square());
    r.set(-2,2,-1,4);
    r.show();
    System.out.println(r.square());
    if(r.equals(s))
      System.out.println("두 사각형의 넓이가 같습니다.");
    else{
      System.out.println("두 사각형의 넓이가 다릅니다.");
    }
  }
}
