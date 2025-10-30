package reservation;

public class Seat {
  private String sSeat;
  private String aSeat;
  private String bSeat;

  public Seat(){
    int[] s = new int[10];
    int[] a = new int[10];
    int[] b = new int[10];

  }

  public Seat(String name, int num) {
  }

  public Seat(int num) {
  }

  public String getsSeat() {
    return sSeat;
  }

  public void setsSeat(String sSeat) {
    this.sSeat = sSeat;
  }

  public String getaSeat() {
    return aSeat;
  }

  public void setaSeat(String aSeat) {
    this.aSeat = aSeat;
  }

  public String getbSeat() {
    return bSeat;
  }

  public void setbSeat(String bSeat) {
    this.bSeat = bSeat;
  }

  public void printSeat(){
    System.out.print("좌석구분 " );
    System.out.print("S<1>, " );
    for (int i =0; i< sSeat.length(); i++){
      System.out.print(sSeat);
    }
    System.out.print("A<2>, " );
    System.out.println("B<3>>> " );
  }
}
