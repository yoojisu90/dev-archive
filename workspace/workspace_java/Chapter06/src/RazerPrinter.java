public class RazerPrinter extends Printer {
  private int tonerBalance;

  public RazerPrinter(String name, String company, String type, int printQuantity, int balance) {
    super(name, company, type, printQuantity, balance);
  }

  public RazerPrinter() {

  }

  public void print(){
    super.print();
    System.out.println("토너 잔량 = " + tonerBalance);
  }
}
