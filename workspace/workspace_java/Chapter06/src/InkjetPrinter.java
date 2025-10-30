public class InkjetPrinter extends Printer{
  private int inkBalance;

  public InkjetPrinter(String name, String company, String type, int printQuantity, int balance) {
    super(name, company, type, printQuantity, balance);
  }

  public InkjetPrinter() {
    super();
  }

  public void print(){
    super.print();
    System.out.println("잉크 잔량 = " +inkBalance);
  }




}
