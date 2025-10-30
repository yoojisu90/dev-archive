//자바스크립트는 함수 선언 방식이 3가지 존재
//기본방식, 함수 표현식, 화살표 함수
//함수는 함수정의문, 함수호출문으로 구분


//기본 방식의 함수 선언
function f1(){
  console.log('f1 함수 실행');
}

//함수표현식으로 선언
//자바스크립트는 함수도 자료형으로 간주!
const f2 = function(){
  console.log('f2 함수 실행');
};

//매개변수로 전달된 두 정수의 합을 출력
const f3 = function(a,b){
  console.log(a+b);
}

//매개변수로 전달된 두 정수의 나눗셈 결과를 리턴
const f4 = function(a,b){
  return a/b;
}

//-------------------------------------------//
f2();
f3(5,10);
const result = f4(10,4);
console.log(result);