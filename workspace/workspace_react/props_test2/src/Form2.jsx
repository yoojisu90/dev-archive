import axios from 'axios';
import React, { useState } from 'react'

const Form2 = () => {
  const [orderData, setOrderData] = useState({
    'type' : '후라이드치킨',
    'cnt' : '1',
    'addr' : '',
    'addrDetail' : '',
    'request' : ''
  });

  const handleOrderData = (e) => {
    setOrderData({
      ...orderData,
      [e.target.name] : e.target.value
    });
  }

  console.log(orderData);

  //주문하러 가기 버튼 클릭 시 실행 함수
  const goOrder = () => {
    axios.post('/api/orders', orderData)
    .then(res => alert('주문 성공'))
    .catch(error => console.log(error));
  }

  return (
    <div>
      <h2>치킨!!</h2>
      <h3>치킨 종류와 상관없이 무조건 만원!</h3>
      <input type="radio" name="type" value='후라이드치킨' 
            checked={orderData.type === '후라이드치킨'}
            onChange={(e) => {handleOrderData(e)}}/> 후라이드치킨
      <input type="radio" name="type" value='양념치킨'
            checked={orderData.type === '양념치킨'} 
            onChange={(e) => {handleOrderData(e)}}/> 양념치킨
      <input type="radio" name="type" value='간장치킨'
            checked={orderData.type === '간장치킨'} 
            onChange={(e) => {handleOrderData(e)}}/> 간장치킨 <br />
      <input type="radio" name="type" value='고추바사삭'
            checked={orderData.type === '고추바사삭'}
            onChange={(e) => {handleOrderData(e)}}/> 고추바사삭
      <input type="radio" name="type" value='뿌링클'
            checked={orderData.type === '뿌링클'}
            onChange={(e) => {handleOrderData(e)}}/> 뿌링클
      <input type="radio" name="type" value='매운핫치킨'
            checked={orderData.type === '매운핫치킨'} 
            onChange={(e) => {handleOrderData(e)}}/> 매운핫치킨 <br />

      몇마리 <input type="number" name='cnt' value={orderData.cnt} 
            onChange={(e) => {handleOrderData(e)}}/> <br />

      배달주소
      <select name='addr' value={orderData.addr} 
                onChange={(e) => {handleOrderData(e)}}>
        <option name='addr'>동을 선택하세요</option>
        <option name='addr' value='삼산동'>삼산동</option>
        <option name='addr' value='달동'>달동</option>
        <option name='addr' value='신천동'>신천동</option>
      </select> <br />

      배달주소 상제 <br />
      <input type="text" name='addrDetail' 
            value={orderData.addrDetail} 
            onChange={(e) => {handleOrderData(e)}}/> <br />

      요청사항 <br />
      <textarea cols={50} rows={5} name='request' 
                value={orderData.request} 
                onChange={(e) => {handleOrderData(e)}}></textarea> <br />

      <button type="button" 
              onClick={(e) => {goOrder()}}>주문하러가기</button>


    </div>
  )
}

export default Form2