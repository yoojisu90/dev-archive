package list.문제1;

public class Test_5 {
  private String id;
  private String pw;
  private String name;
  private int age;

  public Test_5(String id, String pw, String name, int age) {
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
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

  @Override
  public String toString() {
    return "Test_5{" +
            "id='" + id + '\'' +
            ", pw='" + pw + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
