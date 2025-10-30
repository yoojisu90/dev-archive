public class CakeTest {
  public static void main(String[] args) {
    StrawberryCheeseCake cake1 = new StrawberryCheeseCake();
    cake1.eatCake(); // 1번
    cake1.eatCheeseCake(); //2번

    Cake cake2=new StrawberryCheeseCake(); //4번
    //CheeseCake cake4= new Cake(); //5번
    //StrawberryCheeseCake cake5 =new CheeseCake(); //6번
    Cake cake6=new CheeseCake(); //7번

    //cake2.eatCheeseCake(); //8번
    cake2.eatCake(); //9번
    //cake3.eatStrawberryCheaseCake(); //10번
    //cake6.eatCheeseCake(); //11번
  }
}
