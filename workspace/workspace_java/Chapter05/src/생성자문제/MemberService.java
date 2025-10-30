package 생성자문제;

public class MemberService {
  private String id;
  private String pw;

  public boolean logIn(String id, String pw){
    return id.equals("hong") && pw.equals("12345")? true : false;

//    return id.equals("hong") && pw.equals("12345");

//    if(id.equals("hong")&&pw.equals("12345")){
//      return true;
//    }
//    else{
//      return false;
//    }
  }

  public void logOut(String id){
    System.out.println("로그아웃 되었습니다.");
  }

}
