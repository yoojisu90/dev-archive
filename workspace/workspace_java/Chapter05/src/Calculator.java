import java.util.Scanner;

public class Calculator {
  int firstNum;
  int secondNum;
  String oper;


  public void setNum(int firstNum,int secondNum, String oper){
    this.firstNum=firstNum;
    this.secondNum=secondNum;
    this.oper=oper;
  }

  public void setFirstNum(int firstNum){
    this.firstNum=firstNum;
  }
  public void setSecondNum(int secondNum){
    this.secondNum=secondNum;
  }
  public void setOper(String oper){
    this.oper=oper;
  }

  public int getFirstNum(){
    return firstNum;
  }
  public int getSecondNum(){
    return secondNum;
  }
  public String getOper(){
    return oper;
  }

  public void print(){
    Scanner sc = new Scanner(System.in);

    System.out.print("첫 번째 수 : ");
    firstNum = sc.nextInt();
    System.out.print("두 번째 수 : ");
    secondNum = sc.nextInt();
    System.out.print("연산자 : ");
    oper = sc.next();

    if (oper.equals("+")){
      System.out.println(firstNum+" "+ oper +" "+secondNum + " = " + (firstNum  + secondNum));
    }
    else if(oper.equals("-")){
      System.out.println(firstNum+" "+ oper +" "+secondNum + " = " + (firstNum  - secondNum));
    }
    else if(oper.equals("*")){
      System.out.println(firstNum+" "+ oper +" "+secondNum + " = " + (firstNum  * secondNum));
    }
    else if(oper.equals("/")){
      System.out.println(firstNum+" "+ oper +" "+secondNum + " = " + (firstNum  / (double)secondNum));
    }

  }
}
