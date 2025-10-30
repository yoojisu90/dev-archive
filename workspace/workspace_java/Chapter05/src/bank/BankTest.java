package bank;

import java.util.Scanner;

public class BankTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Bank test = new Bank();


    while (true){
      System.out.print("1.계좌개설  ");
      System.out.print("2.입금  ");
      System.out.print("3.출금  ");
      System.out.print("4.예금조회  ");
      System.out.print("5.전체조회  ");
      System.out.print("6.은행업무종료 => ");
      int a= sc.nextInt();

      if(a==1){
        test.displayBank1();
      }
      else if (a == 2) {
        test.inMoney();
      }
      else if (a == 3) {

      }
      else if (a == 4) {
        test.accInfo();
      }
      else if (a == 5) {

      }
      else if (a == 6) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

    }
  }
}
