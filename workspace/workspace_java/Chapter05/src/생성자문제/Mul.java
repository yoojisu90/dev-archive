package 생성자문제;

public class Mul {
  private int a;
  private int b;
  private String oper;

  public void setValue(int a,int b){
    this.a = a;
    this.b = b;
  }

  public int calculate(){
    return a*b;
  }
}
