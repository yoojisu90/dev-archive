//기본 방식
function f1(){
  console.log(1);
}

//함수표현식
const f2 = function(){
  console.log(1);
}

//화살표 함수
//함수의 내용이 한 줄이면 중괄호 생략 가능!
const f3 = () => console.log(1);

//매개변수로 전달된 두 정수의 합을 출력
const f4 = (a,b) => console.log(a+b);

//매개변수로 전달된 데이터를 출력
//매개변수가 하나라면 매개변수의 소괄호 생략 가능
const f5 = a => console.log(a);

//매개변수로 전달된 수 *3 한 데이터를 리턴
//함수의 내용이 return이면 중괄호 생략과 함께
//return키워드도 같이 생략해야 함!
const f6 = a => a*3;


//--------------------------------------------//
f3();
f4(5,10);
f5('ㅎㅇ');
const result = f6(5);
console.log(result);