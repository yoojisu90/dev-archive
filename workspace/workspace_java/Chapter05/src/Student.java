public class Student {
  String name;
  int age;
  String address;
  String stuNum;
  String number;

  public void reset(String newName,int newAge,String newAddress,String newStuNum,String newNumber){
    name=newName;
    age=newAge;
    address=newAddress;
    stuNum=newStuNum;
    number=newNumber;
  }

  //멤버변수 각각의 값을 변경하는 메소드 -> setter라고 부름!
  public void setName(String newName){
    name=newName;
  }
  public void setAge(int newAge){
    age=newAge;
  }
  public void setAddress(String newAddress){
    address=newAddress;
  }
  public void setGrade(String newStuNum){
    stuNum=newStuNum;
  }
  public void setNumber(String newNumber){
    number=newNumber;
  }

  //멤버변수 각각의 값을 리턴하는 메소드 -> getter라고 부름!
  //getter는 메서드명이 정해져 있음!. get변수명으로 메서드명 정해져있음!
  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
  public String getAddress(){
    return address;
  }
  public String getStuNum(){
    return stuNum;
  }
  public String getNumber(){
    return number;
  }

  public void print(){
    System.out.println("이름 : " + name);
    System.out.println("나이 : " + age);
    System.out.println("주소 : " + address);
    System.out.println("학번 : " + stuNum);
    System.out.println("연락처 : " + number);
  }


}
