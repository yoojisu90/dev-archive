public class MemberTest {
  public static void main(String[] args) {
    Member test1 = new Member();
    Member test2 = new Member();

    test1.info("홍길동","abc","def",20);
    test2.info("유관순","abc","1234",30);

    test1.printInfo();
    System.out.println();
    test2.printInfo();
  }
}
