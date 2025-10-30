import javax.naming.Name;

public class Man {
  String name;

  public Man(String name){
    this.name = name;
  }

  public void tellName(){
    System.out.println("Name is " + name);
  }
}

//해당 클래스는 Man클래스를 상속한다
//상속하는 클래스의 맴버변수와 메서드를 상속 받게 됨
// -> 맴버변수와 메서드를 내 것처럼 사용 가능!

//상속 관계에 있는 자식 클래스의 객체를 생성할 때,
//내부적으로 부모 클래스의 객체도 생성한다.
//부모 클래스의 객체를 생성할 때도 생성자를 호출해서 객체를 만든다.
//이때, 호출되는 생성자는 매개변수가 없는 생성자를 호출한다.
//그리고, 이렇게 부모클래스의 기본생성자를 호출하는 문법은 숨겨져있다.(생략되어 있다)
//생략되어 있는 부모클랫의 생성자 호출 문법은
//자식 클래스의 생성자 첫줄에 super() 라는 키워드로 생략되어 있다.
class BusinessMan extends Man{
  String company;

  public BusinessMan(String company){
    super("kim");//부모클래스의 생성자 호출 문법
    this.company = company;
  }

  public void tellCompany(){
    System.out.println("Company is " + company);
  }
}
