import java.util.Stack;

public class Bank {
  int money; //예금액
  String owner; //소유주
  static double iyul; //이율

  static {
    iyul = 5.0;
  }

  public Bank(String owner){
    money = 10000;
//    iyul = 5.0;
    this.owner = owner;

  }

  public static void aaa(){
    System.out.println(123);

  }

  public void bbb(){
    System.out.println("aaa");
  }

}
