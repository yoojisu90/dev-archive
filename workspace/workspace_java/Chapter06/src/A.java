public class A {
  private int x;
  private int y;

  public A(){
    this.x =1;
    this.y =1;
  }

  public A(int x){
    this.x=x;
    this.y=1;
  }
  public A(int x, int y){
    this.x=x;
    this.y=y;
  }

  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
}

class B extends A{
  private int x;
  private int y;

  public B(){
    super();
    this.x =1;
    this.y =1;

  }

  public B(int a){
    super(a);
    this.x =1;
    this.y =1;

  }
  public B(int a, int b){
    super(a,b);
    this.x =1;
    this.y =1;

  }
  public B(int a, int b,int x){
    super(a,b);
    this.x =x;
    this.y =1;

  }
  public B(int a, int b,int x, int y){
    super(a,b);
    this.x =x;
    this.y =y;

  }

  public void disp(){
    System.out.println("x = " + getX() + ", y = " + getY() + ", x = " + x + ", y = " + y);
  }

}




