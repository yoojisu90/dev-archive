public class ComputerTest {
  public static void main(String[] args) {
    Computer c1 = new Computer("삼성",1000);
    c1.display();

    //참조자료형은 선언하면 무조건 null 가짐
    int[] aaa; //null
    String a; //null

    Computer c2 = c1;
    c2.display();

    c2.price = 2000;
    System.out.println(c2.price);
    System.out.println(c1.price);

    int[]arr = {1,2,3};

    Computer[] array = new Computer[3];

  }

  public Computer test(Computer c){
    c.display();
    return c;
  }

}
