public class Book {
  String title;
  String writer;
  int price;

  //제목을 변경하는 메서드
  //this. -> 클래스에서 선언된
  public void setTitle(String title){
    this.title = title;
  }

  //책의 모든 정보를 변경하는 메서드
  public void setBook(String title, String writer, int price){
    this.title = title;
    this.writer = writer;
    this.price = price;
  }



}
