package bank;

import java.util.Scanner;

public class Bank {
  private String open;
  private String inAccNum;
  private String outAccNum;
  private String search;
  private Customer[] customers;
  private int cnt;
  private Scanner sc;

  public Bank(){
    customers = new Customer[5];
    cnt = 0;
    sc = new Scanner(System.in);
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  public String getInAccNum() {
    return inAccNum;
  }

  public void setInAccNum(String inAccNum) {
    this.inAccNum = inAccNum;
  }

  public String getOutAccNum() {
    return outAccNum;
  }

  public void setOutAccNum(String outAccNum) {
    this.outAccNum = outAccNum;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public Customer[] getCustomers() {
    return customers;
  }

  public void setCustomers(Customer[] customers) {
    this.customers = customers;
  }

  //1. 계좌 개설
  public void displayBank1(){
    System.out.println("계좌개설을 시작합니다.");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("주민등록번호 : ");
    String regNum = sc.next();
    System.out.print("연락처 : ");
    String phoneNum= sc.next();
    System.out.print("계좌번호 : ");
    String accNum = sc.next();

    Customer person = new Customer();
    customers[cnt] = person;
    cnt++;
  }

  //2.입금
  public void inMoney(){
    System.out.print("입금계좌번호 : ");
    String inNum = sc.next();
    for(int i=0; i<cnt; i++){

    }
    System.out.print("현재 총 예금액은 " +   "원입니다. 예금액을 입력하세요 : ");
    int money = sc.nextInt();
    for (int i=0; i<cnt; i++){
      money = money + 10000;
      System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + money + "웝입니다.");
    }
  }
  //3.출금
  //4.예금조회
  public void accInfo(){
    System.out.print("계좌번호 : ");
    String accNum = sc.next();
    for(int i=0; i<cnt; i++){
      System.out.println("현재 총 예금액은 " + accNum +"원입니다.");
    }
  }

  //5.전체조회

}
