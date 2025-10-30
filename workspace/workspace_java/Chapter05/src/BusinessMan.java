public class BusinessMan {
  private int num;
  private String name;
  private String group;

  public BusinessMan(){}

  public BusinessMan(int num, String name, String group) {
    this.num = num;
    this.name = name;
    this.group = group;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void display(){
    System.out.println("사번 : "+num);
    System.out.println("사원명 : "+name);
    System.out.println("부서명 : "+group);
  }
}
