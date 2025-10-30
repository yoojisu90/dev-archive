public class CountTest2 {
  public static void main(String[] args) {
    System.out.println(Count.cnt);
    Count.cnt = 10;
    System.out.println(Count.cnt);

    Count c1 = new Count();
    System.out.println(Count.cnt);

  }
}

//static 변수 생성 ->

class 학생{} //학생 한 명의 정보를 저장할수 있는 자료형
class DeskTop{} //책상 하나의 정보를 저장하는 클래스
class Aircon{} //

class 자바반{
  private 학생[] 학생들;
  private DeskTop[] deskTops;
  static Aircon aircon;
}