package reservation;

import java.util.Scanner;

public class ReservationTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Reservation test = new Reservation();

    while (true) {
      System.out.print("예약<1>, ");
      System.out.print("조회<2>, ");
      System.out.print("취소<3>, ");
      System.out.print("끝내기<4>>> ");

      int a = sc.nextInt();
      if(a==1){
        test.regSeat();
        test.regPerson();
      }
      if(a==2){
        System.out.println("<<<조회를 완료하였습니다>>>");
        test.printReserve();
      }
      if(a==3){

      }
      if(a==4){
        System.out.println("<<<프로그램을 종료합니다>>>");
        break;
      }
    }
  }
}
