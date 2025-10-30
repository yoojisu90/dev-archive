public class SongTest {
  public static void main(String[] args) {
    Song test = new Song();
    test.reset("제목", "가수", "1집", 2025, new String[]{"아티", "스트", "3명"});
    test.print();

  }
}
