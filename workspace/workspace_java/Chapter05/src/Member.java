public class Member {
  String name;
  String id;
  String password;
  int age;

  public void info(String newName, String newId, String newPassword, int newAge){
    name = newName;
    id = newId;
    password = newPassword;
    age = newAge;
  }

  public void printInfo(){
    System.out.println(name);
    System.out.println(id);
    System.out.println(password);
    System.out.println(age);
  }

}

