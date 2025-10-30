import axios from 'axios';
import React, { useState } from 'react'

const inputTest1 = () => {
  //input 태그에 입력한 글자를 저장할 state 변수
  //input 태그에 입력한 데이터를 저장할 변수의 초기값은 빈 문자열로 선언
  const [orderNum, setOrderNum] = useState('');
  console.log(orderNum);

  return (
    <div>
      <div>조회할 상품번호를 입력하세요</div>
      {/* 모든 이벤트 함수는 이벤트의 모든 정보를 가진 매개변수(객체)를 가진다. */}
      {/* input 태그에 입력한 정보는 value 속성으로 지정 */}
      <input type="text" onChange={(e) => {
        //console.log(e.target);
        //console.log(e.target.value);
        setOrderNum(e.target.value);
        //setOrderNum(인풋 태그에 작성된 글자);
      }}/> <br />
      <button id ='abc' className ='ddd' type="button" onClick={(e)=>{
        console.log(e.target);
        console.log(e.target.type);
        console.log(e.target.id);
        console.log(e.target.className);

        axios.get(`/api/orders/${orderNum}`)
        .then(res => console.log(res.data))
        .catch(error => console.log(error));
      }}>조회</button>
    </div>
  )
}

export default inputTest1