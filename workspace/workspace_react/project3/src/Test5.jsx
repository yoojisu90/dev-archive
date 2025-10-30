import React, { useState } from 'react'

const Test5 = () => {
  const [arr, setArr] = useState({
    name : '김자바',
    age : 20,
    addr : '울산시'
  });

  return (
    <div>
      <h3>이름 : {arr.name}</h3>
      <h3>나이 : {arr.age}</h3>
      <h3>주소 : {arr.addr}</h3>

      <div>
        <button type="button" onClick={()=>{
          const copyArr = {...arr};
          copyArr.name = '홍길동';
          setArr(copyArr);
        }}>이름을 홍길동으로 변경</button>
        <button type="button" onClick={()=>{
          const copyArr = {...arr};
          copyArr.age = 30;
          setArr(copyArr);
        }}>나이를 30으로 변경</button>
        <button type="button" onClick={()=>{
          const copyArr = {...arr};
          copyArr.addr = '서울시';
          setArr(copyArr);
        }}>주소를 서울시로 변경</button>
      </div>
    </div>
  )
}

export default Test5