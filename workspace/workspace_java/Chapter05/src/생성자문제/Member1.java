package 생성자문제;

public class Member1 {
  private String name;
  private String id;
  private String pw;

  public Member1(){

  }
  public Member1(String name , String id, String pw){
    this.name = name;
    this.id = id;
    this.pw = pw;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }
  public String getId() {
    return id;
  }
  public String getPw() {
    return pw;
  }

  public void displayInfo(){
    System.out.println(name);
    System.out.println(id);
    System.out.println(pw);
  }
}
