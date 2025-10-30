import axios from 'axios';
import React, { useState } from 'react'

const InputTest2 = () => {
  //input 태그에 입력한 내용을 저장할 state 변수
  const [orderInfo, setOrderInfo] = useState({
    'productName' : '',
    'price' : 0,
    'cnt' : 1
  });

  console.log(orderInfo);

  //버튼 안의 axios를 화살표 함수로 생성해서 사용하는것이 가독성이 좋음
  const regOrder = ()=>{
    axios.post('/api/orders', orderInfo)
    .then(res => console.log(res.data))
    .catch(error => console.log(error));
  }
 
  return (
    <div>
      상품명 : <input value={orderInfo.productName} type="text" onChange={(e)=> {
        setOrderInfo({
          ...orderInfo, 
          'productName' : e.target.value
        });
      }}/> <br />
      상품가격 : <input value={orderInfo.price} type="text" onChange={(e)=> {
        setOrderInfo({
          ...orderInfo, 
          'price' : e.target.value
        });
      }}  /> <br />
      수량 : <input value={orderInfo.cnt} type="text" onChange={(e)=> {
        setOrderInfo({
          ...orderInfo, 
          'cnt' : e.target.value
        });
      }}/> <br />

      <button type="button" onClick={e=> regOrder()}>등록</button>

    </div>
  )
}

export default InputTest2