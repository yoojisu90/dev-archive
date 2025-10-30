package reservation;

import stu.Program;

import java.util.Scanner;

public class Reservation {
  private String name;
  private int num;
  private Seat[] seats;
  private int cnt;
  private Scanner sc;

  public Reservation(){

    seats = new Seat[10];
    cnt = 0;
    sc = new Scanner(System.in);
  }

  public Reservation(String name, int num) {
  }

  //좌석 구분
  public void regSeat(){
    System.out.print("좌석구분 " );
    System.out.print("S<1>, " );
    System.out.print("A<2>, " );
    System.out.print("B<3>>> " );
    int num = sc.nextInt();

    Seat seat = new Seat(num);

    seats[cnt] = seat;
    cnt++;
  }

  //예약 등록
  public void regPerson(){
    System.out.print("이름>> " );
    String name = sc.next();
    System.out.print("번호>> " );
    int num = sc.nextInt();

    Reservation person = new Reservation(name,num);
    cnt++;
  }

  //예약 조회
  public void printReserve(){
    for(int i=0; i< seats.length; i++){

      System.out.println(seats[i]);
    }
  }

}