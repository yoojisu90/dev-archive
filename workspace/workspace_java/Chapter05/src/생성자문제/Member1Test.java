package 생성자문제;

public class Member1Test {
  public static void main(String[] args) {
    Member1 m1 =new Member1();
    m1.setName("자바");
    m1.setId("java");
    m1.setPw("123");
    m1.displayInfo();


    Member1 test = new Member1("자바","java","123");
    test.displayInfo();

  }
}
