import java.util.ArrayList;
import java.util.List;

public class FriendTest2 {
  public static void main(String[] args) {
    List<Friend> friendList = new ArrayList<>();

    friendList.add(new UnivFriend("김","111","디자인"));
    friendList.add(new UnivFriend("이","222","생물"));
    friendList.add(new UnivFriend("박","333","천체"));
    friendList.add(new CompFriend("김","123","영업부"));
    friendList.add(new CompFriend("최","456","회계부"));
    friendList.add(new CompFriend("윤","789","인사부"));

    for(int i=0; i< friendList.size(); i++){
      friendList.get(i).showInfo();
    }

  }
}
