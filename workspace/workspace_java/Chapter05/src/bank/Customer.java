package bank;

public class Customer {
  private String name;
  private String regNum;
  private String phoneNum;
  private Acc accs;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegNum() {
    return regNum;
  }

  public void setRegNum(String regNum) {
    this.regNum = regNum;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Acc getAccs() {
    return accs;
  }

  public void setAccs(Acc accs) {
    this.accs = accs;
  }


}
