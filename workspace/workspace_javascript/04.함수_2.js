
function test(){
  alert(1);
}

function test1(num1, num2){
  const a = num1+num2;
  // a % 2 === 0 ? alert(1) : alert(2);
  alert(a % 2 === 0 ? 1 : 2);
}

function test2(arr1, arr2){
  let sum1 = 0;
  for(let i=0; i<arr1.length; i++){
    sum1 = sum1 + arr1[i];
  }
  let sum2 = 0;
  for(let i=0; i<arr2.length; i++){
    sum2 = sum2 + arr2[i];
  }

  alert(sum1 - sum2);
}

function test3(){
  const array1 = [3, 5.5, [1, 2, 4]];
  alert (array1[2][2]);
}