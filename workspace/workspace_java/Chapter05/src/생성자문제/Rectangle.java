package 생성자문제;

public class Rectangle {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Rectangle() {

  }

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public void set(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
/*

  public void setX1(int x1) {
    this.x1 = x1;
  }
  public void setY1(int y1) {
    this.y1 = y1;
  }
  public void setX2(int x2) {
    this.x2 = x2;
  }
  public void setY2(int y2) {
    this.y2 = y2;
  }

  public int getX1() {
    return x1;
  }
  public int getY1() {
    return y1;
  }
  public int getX2() {
    return x2;
  }
  public int getY2() {
    return y2;
  }
*/

  public int square() {
    return (x2 - x1) * (y2 - y1);
  }

  public void show() {
    System.out.print("x1좌표: " + x1 + ", ");
    System.out.print("y1좌표: " + y1 + ", ");
    System.out.print("x2좌표: " + x2 + ", ");
    System.out.print("y2좌표: " + y2 + " ");
    System.out.println("넓이: " + (x2 - x1) * (y2 - y1));
  }

  public boolean equals(Rectangle r) {
    return square()==r.square();
  }

}
