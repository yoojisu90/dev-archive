import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
  public static void main(String[] args) {
    InkjetPrinter inkjetPrinter = new InkjetPrinter();
    RazerPrinter razerPrinter = new RazerPrinter();
    List<Printer> printers = new ArrayList<>();
    Printer p1 = new Printer("삼성프린트기","삼성","ink",0,100);
    Printer p2 = new Printer("LG프린트기","LG","razer",0,100);


    inkjetPrinter.print();
    razerPrinter.print();



  }
}
