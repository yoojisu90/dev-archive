package list.문제2;

public class EmpTest {
  public static void main(String[] args) {
    EmpService test = new EmpService();

    test.logIn();
    System.out.println("--------------------------------------------");
    test.avg();
    System.out.println("--------------------------------------------");
    test.pay();

  }
}
