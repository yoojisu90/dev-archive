import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import styles from './ItemDetail.module.css'
import dayjs from 'dayjs';

const ItemDetail = () => {
  const {itemNum} = useParams();
  const nav = useNavigate();

  const [item, setItem] = useState({});
  
  console.log(item)

  //조회
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => setItem(res.data))
    .catch(e => console.log(e))
  }, []);

  //삭제함수
  const del = () => {
    const result = confirm('삭제할까요?')

    if(result){
      axios.delete(`/api/items/${itemNum}`)
      .then(res =>{
        alert(`${itemNum}번의 아이템을 삭제합니다`)
        nav('/');
      })
      .catch(e => console.log(e))
    }
  }


  return (
    <div className={styles.container}>
      <table>
        <tbody>
          <tr>
            <td>상품번호</td>
            <td>{item.itemNum}</td>
            <td>카테고리</td>
            <td>{item.itemCategory}</td>
          </tr>
          <tr>
            <td>상품명</td>
            <td>{item.itemName}</td>
            <td>가격</td>
            <td>{item.itemPrice && item.itemPrice.toLocaleString()}</td>
          </tr>
          <tr>
            <td>상태</td>
            <td>{item.itemStatus}</td>
            <td>등록일</td>
            <td>{dayjs(item.regDate).format('YYYY-MM-DD HH:mm:ss')}</td>
          </tr>
          <tr>
            <td>상품소개</td>
            <td colSpan={3}>{item.itemIntro}</td>
          </tr>
        </tbody>
      </table>
      <div className={styles.button_div}>
        <button type="button" onClick={e => nav('/')}>목록가기</button>
        <button type="button" onClick={e => nav(`/update/${itemNum}`)}>수정</button>
        <button type="button" onClick={e => del()}>삭제</button>
      </div>

    </div>
  )
}

export default ItemDetail