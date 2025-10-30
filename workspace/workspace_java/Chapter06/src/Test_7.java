public class Test_7 {
  class A{
    private int n;
    public int getN(){
      return n;
    }
    public void setN(int i){
      n =i;
    }
  }

  class B extends A{
    public String s;
//    private int n;
    public int m;
    public char c;
//    public void setN(int i){
//      n = i;
//    }
    public void setC(char ch){
      c = ch;
    }
    public char getC(){
      return c;
    }
//    public int getN(){
//      return n;
//    }
  }

  class C extends B{
//    public String s;
    public double d;
//    private int n;
//    public int m;
//    public void setN(int i){
//      n=i;
//    }
//    public void setC(char ch){
//      c=ch;
//    }
//    public char getC(){
//      return c;
//    }
//    public int getN(){
//      return n;
//    }
//
  }
}
