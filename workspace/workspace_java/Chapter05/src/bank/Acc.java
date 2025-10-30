package bank;

public class Acc {
  private int accNum;
  private int money;

  public Acc(){
    money = 10000;
  }

  public int getAccNum() {
    return accNum;
  }

  public void setAccNum(int accNum) {
    this.accNum = accNum;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void printAcc(){
    System.out.println("계좌번호 : " + accNum);
    System.out.println("현재 총 예금액은 " + money + "원입니다.");
  }
}
