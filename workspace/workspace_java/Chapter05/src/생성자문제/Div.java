package 생성자문제;

public class Div {
  private int a;
  private int b;
  private String oper;

  public void setValue(int a,int b){
    this.a = a;
    this.b = b;
  }

  public double calculate(){
    return a/(double)b;
  }
}
