public class Man {
  String name;
  int age;
  String address;

  public void reset(String newName,int newAge,String newAddress){
   name=newName;
   age=newAge;
   address=newAddress;
  }

  public void setName(String newName){
    name=newName;
  }
  public void setAge(int newAge){
    age=newAge;
  }
  public void setAddress(String newAddress){
    name=newAddress;
  }

  public String re1(){
    return name;
  }
  public int re2(){
    return age;
  }
  public String re3(){
    return address;
  }

  public void print(){
    System.out.println("이름 : " + name);
    System.out.println("나이 : " + age);
    System.out.println("주소 : " + address);

  }

}
