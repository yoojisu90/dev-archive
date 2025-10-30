public class 연산자_2 {
  public static void main(String[] args) {
    //증감연산자 : 값을 1 증가 혹은 감소 시키는 연산자

    //사전 지식 체크
    int x = 10;

    //x의 값을 1 증가시키는 코드
    x = x + 1;

    int a = 5;
    ++a; //a의 값을 1증가
    a++; //a의 값을 1증가
    System.out.println(a);
    --a; //a의 값을 1감소
    a--; //a의 값을 1감소
    System.out.println(a);

    System.out.println();

    //++, -- 기호가 변수 앞에 붙어 있으면 숫자를 먼저 1증가 후 다른 배용을 실행
    //++, -- 기호가 변수 뒤에 붙어 있으면 다른 내용을 먼저 실행 후 숫자를 1증가
    int b = 10;
    int c = ++b;
    System.out.println(b);
    System.out.println(c);

    int d = 10;
    int e = d++;
    System.out.println(d);
    System.out.println(e);

    int aa = 10;
    int bb = 20;
    int cc = ++aa + bb--;
    System.out.println(aa); //11
    System.out.println(bb); //19
    System.out.println(cc); //31

    //복합대입연산자
    int z = 5;

    //z 값을 1감소 시키는 코드
    z = z - 1;
    z--;
    --z;
    z -= 1;

    z += 3; // z = z + 3;
    z *= 2; // z = z * 2;
    z = z / 5; // z /= 5;
    z %= 2; // z = z % 2;

  }
}
