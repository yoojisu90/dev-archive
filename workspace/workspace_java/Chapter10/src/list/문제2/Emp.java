package list.문제2;

public class Emp {
  private int regNum;
  private String name;
  private String dept;
  private String phoneNum;
  private int salary;

  public Emp(int regNum, String name, String dept, String phoneNum, int salary) {
    this.regNum = regNum;
    this.name = name;
    this.dept = dept;
    this.phoneNum = phoneNum;
    this.salary = salary;
  }

  public int getRegNum() {
    return regNum;
  }

  public void setRegNum(int regNum) {
    this.regNum = regNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "regNum=" + regNum +
            ", name='" + name + '\'' +
            ", dept='" + dept + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", salary=" + salary +
            '}';
  }

}
