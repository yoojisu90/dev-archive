import java.util.Arrays;

public class Song {
  String title;
  String artist;
  String album;
  int year;
  String[] composer;

  public void reset(String newTitle, String newArtist, String newAlbum, int newYear, String[] newComposer){
    title = newTitle;
    artist = newArtist;
    album = newAlbum;
    year = newYear;
    composer = newComposer;

  }

  public void print(){
    System.out.println("노래제목 : " + title);
    System.out.println("가수 : " + artist);
    System.out.println("앨범제목 : " + album);
    System.out.println("발표된 연도 : " + year);
    System.out.println("작곡가 : " + Arrays.toString(composer));
  }

}
