package stu;

public class Program {
  private String name;
  private int age;
  private String num;
  private String grade;

  public Program(String name, int age, String num, String grade) {
    this.name = name;
    this.age = age;
    this.num = num;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public void print(){
    System.out.print("이름 : " + name + ", ");
    System.out.print("나이 : " + age + ", ");
    System.out.print("연락처 : " + num + ", ");
    System.out.println("학점 : "+ grade);
  }
}
