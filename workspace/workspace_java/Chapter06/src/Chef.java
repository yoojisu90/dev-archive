public class Chef {
  public void makeCook(){
    System.out.println("쉐프가 요리 합니다.");
  }

}

class MasterChef extends Chef{
  public void makeCook(){
    System.out.println("마스터 쉐프가 요리 합니다.");
  }
  public void giveOrder(){
    System.out.println("요리사에게 지시합니다.");
  }
}
