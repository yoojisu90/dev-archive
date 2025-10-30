public class AccTest {
  public static void main(String[] args) {
    //초기화
    // - 모든 다른 기능보다 먼저 실행되야 함
    // - 초기화는 최초 1회만 실행 되어야 한다.

    //클래스명 객체명 = new 생성자호출();
    Account acc1 = new Account();
    acc1.printAcc();

    Account acc2 = new Account(1000);
    acc2.printAcc();

    Account acc3 = new Account("1111",5000,"kim");
    acc3.printAcc();

    //계좌정보 초기화
    //acc.initAcc("1111", 1000, "kim");
    //acc.printAcc();

  }
}
