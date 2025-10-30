import java.util.Base64;

public class BusinessManTest {
  public static void main(String[] args) {
    BusinessMan b1 = new BusinessMan(1,"kim","개발부");
    BusinessMan b2 = new BusinessMan(2,"lee","영업부");
    BusinessMan b3 = new BusinessMan(3,"park","기술부");
    BusinessMan b4 = new BusinessMan(4,"choi","개발부");
    BusinessMan b5 = new BusinessMan(5,"jung","인사부");

    BusinessMan[] test = new BusinessMan[5];
    test[0] = b1;
    test[1] = b2;
    test[2] = b3;
    test[3] = b4;
    test[4] = b5;

    for(BusinessMan e : test){
      if(e.getGroup().equals("개발부")){
        e.display();
      }
    }

    for(BusinessMan e : test){
      if(e.getNum()>=3){
        System.out.println(e.getName());
      }
    }

    for(BusinessMan e : test){
      if(e.getGroup().equals("개발부") && e.getNum() % 2 ==0){
        e.display();
      }
    }
  }
}
