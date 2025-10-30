package 생성자문제;

public class MemberServiceTest {
  public static void main(String[] args) {
    MemberService test = new MemberService();
    boolean result = test.logIn("hong","12345");
    if(result){
      System.out.println("로그인 되었습니다.");
      test.logOut("hong");
    }
    else{
      System.out.println("id 또는 password가 올바르지 않습니다.");
    }
  }
}
