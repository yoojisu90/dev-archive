package list.문제2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
  private Scanner sc;
  private List<Emp> empList;

  public EmpService() {
    sc = new Scanner(System.in);
    empList = new ArrayList<>();

    empList.add(new Emp(1001, "홍길동", "개발부", "010-4561-0000", 3000));
    empList.add(new Emp(1002, "김길동", "인사부", "010-1546-1111", 2000));
    empList.add(new Emp(1003, "최길동", "개발부", "010-2048-2222", 2000));
    empList.add(new Emp(1004, "김덕배", "생산부", "010-4564-3333", 5000));
    empList.add(new Emp(1005, "김자바", "인사부", "010-4407-4444", 3000));
    empList.add(new Emp(1006, "이언어", "생산부", "010-5488-5555", 1000));
    empList.add(new Emp(1007, "이순신", "인사부", "010-1567-6666", 1000));
    empList.add(new Emp(1008, "박장군", "개발부", "010-8487-7777", 5000));
    empList.add(new Emp(1009, "황이이", "생산부", "010-0787-8888", 2000));
    empList.add(new Emp(1010, "최배달", "개발부", "010-7816-9999", 1000));
  }

  //메서드의 return의 역할
  //1.메서드의 결과 데이터를 반환(리턴)
  //2.메서드 안의 리턴을 return; 이렇게 사용하면 메서드를 종료하라는 의미
  public void logIn(){
    while(true) {
      System.out.print("사번 : ");
      int num = sc.nextInt();
      System.out.print("비밀번호(연락처의 마지막 4자리) : ");
      String pw = sc.next();
      for (int i = 0; i < empList.size(); i++) {
        if (empList.get(i).getRegNum() == num
                && empList.get(i).getPhoneNum().substring(empList.get(i).getPhoneNum().length() - 4).equals(pw)) {
          System.out.println("로그인 하였습니다.");
          System.out.println("'" + empList.get(i).getName() + "'님 반갑습니다.");
          return;
        }
      }
      System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
    }
  }

  public void avg(){
    System.out.print("부서명 : ");
    String dept = sc.next();
    System.out.println("==" + dept + " 월급 현황==");
    int sum = 0;
    int cnt = 0;
    for (int i=0; i< empList.size(); i++){
      if(empList.get(i).getDept().equals(dept)){
        sum = sum + empList.get(i).getSalary();
        cnt++;
        System.out.print("이름 : " + empList.get(i).getName() + ",  ");
        System.out.println("월급 : " + empList.get(i).getSalary());
      }
    }
    System.out.println(dept+"서의 월급 총액은 " + sum + "원이며, 평균 급여는 " + (sum/(double)cnt) + "원입니다.");
  }

  public void pay(){
    System.out.print("부서명 : ");
    String dept = sc.next();
    System.out.print("인상급여 : ");
    int pay = sc.nextInt();
    System.out.println(dept + " 각 사원의 급여가 각각 " + pay + "원씩 인상됩니다.");
    System.out.println("==월급 인상 후 " + dept + " 월급 현황==");
    int sum = 0;
    for (int i=0; i< empList.size(); i++){
      if(empList.get(i).getDept().equals(dept)){
        sum = empList.get(i).getSalary() + pay;
        System.out.print("이름 : " + empList.get(i).getName() + ",  ");
        System.out.println("월급 : " + sum);
      }
    }
  }


}
