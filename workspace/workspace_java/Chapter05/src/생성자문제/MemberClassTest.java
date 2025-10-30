package 생성자문제;

public class MemberClassTest {
  public static void main(String[] args) {
    MemberClass user1 = new MemberClass("홍길동", "hong");
    MemberClass user2 = new MemberClass("김자바", "java");
    user1.print();
    user2.print();

  }
}
