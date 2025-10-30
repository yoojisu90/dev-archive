import axios from 'axios';
import dayjs from 'dayjs';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import styles from './ItemList.module.css'

const ItemList = () => {
  const [itemList, setItemList] = useState([]);
  
  const nav = useNavigate();

  //조회
  useEffect(() => {
    axios.get('/api/items')
    .then(res => {
      setItemList(res.data);
    })
    .catch(e => console.log(e))
  }, []);

  //가격 저장할 State변수
  // const [totalPrice, setTotalPrice] = useState({
  //   'itemPrice' : ''
  // });

  // console.log(totalPrice)

  // useEffect(() => {
  //   let total = 0;
  //   for (let i = 0; i < itemList.length; i++) {
  //     total = total + itemList[i].itemPrice;
  //     setTotalPrice({
  //       'itemPrice' : total
  //     });
  //   }
  // }, [itemList]);
  let totalPrice = 0;
  for(const e of itemList){
    totalPrice = totalPrice + e.itemPrice;
  }

  return (
    <div className={styles.container}>
      <table>
        <colgroup>
          <col width={'5%'}/>
          <col width={'15%'}/>
          <col width={'15%'}/>
          <col width={'15%'}/>
          <col width={'10%'}/>
          <col width={'*'}/>
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>카테고리</td>
            <td>상품명</td>
            <td>가격</td>
            <td>상태</td>
            <td>등록일</td>
          </tr>
        </thead>
        <tbody>
        {
          itemList.map((item, i) => {
             return(
              <tr key={i}
                onClick={e => nav(`/detail/${item.itemNum}`)}
              >
                <td>{itemList.length - i}</td>
                <td>{item.itemCategory}</td>
                <td>{item.itemName}</td>
                <td>{'￦' + item.itemPrice.toLocaleString()}</td>
                <td>{item.itemStatus}</td>
                <td>{dayjs(item.regDate).format('YYYY-MM-DD HH:mm:ss')}</td> 
              </tr>
             ) 
          })
        
        }
        </tbody>
      </table>
      <div>
        <div>총 등록 가격</div>
        <div>{'￦' + totalPrice.toLocaleString()}</div>
      </div>
      <button type="button" onClick={e => nav('/reg')}>상품 등록</button>
    </div>
  )
}

export default ItemList