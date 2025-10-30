package 생성자문제;

public class MemberClass {
  private String name;
  private String id;
  private String pw;
  private int age;

  public MemberClass(String name, String id){
    this.name = name;
    this.id = id;
  }

  public void print(){
    System.out.println(name);
    System.out.println(id);
    System.out.println(pw);
    System.out.println(age);
  }

}

