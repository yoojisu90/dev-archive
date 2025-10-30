public class Printer {
  private String name;
  private String company;
  private String type;
  private int printQuantity;
  private int balance;

  public Printer(String name, String company, String type, int printQuantity, int balance) {
    this.name = name;
    this.company = company;
    this.type = type;
    this.printQuantity = printQuantity;
    this.balance = balance;
  }

  public Printer() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPrintQuantity() {
    return printQuantity;
  }

  public void setPrintQuantity(int printQuantity) {
    this.printQuantity = printQuantity;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void print(){
    System.out.println("모델명 ='" + name);
    System.out.println("제조사 ='" + company);
    System.out.println("인터페이스종류 ='" + type);
    System.out.println("인쇄 매수 ='" + printQuantity);
    System.out.println("인쇄 종이 잔량 ='" + balance);
  }

}
