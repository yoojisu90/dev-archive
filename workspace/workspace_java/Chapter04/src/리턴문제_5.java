public class 리턴문제_5 {
  public static void main(String[] args) {
    String grade = test(91);
    System.out.println(grade);

  }

  public static String test(int a){
    if(a>=90){
      return "A";
    }
    else if(a>=70){
      return "B";
    }
    else{
      return "C";
    }


  }
}
