import React, { useEffect, useState } from 'react'
import styles from './UpdateForm.module.css'
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
  const {itemNum} = useParams();
  
  const nav = useNavigate();

  //조회된 기존 데이터를 저장할 state 변수
  const [item, setItem] = useState({});

  //바뀐 내용을 저장할 state 변수(입력한 데이터)
  const [updateItem, setUpdateItem] = useState({
    'itemCategory' : '',
    'itemName' : '',
    'itemPrice' : '',
    'itemStatus' : '',
    'itemIntro' : ''
  });

  console.log(updateItem)
  
  
  useEffect(() => {
    if(Object.keys(item).length !== 0){
      setUpdateItem({
        'itemCategory' : item.itemCategory,
        'itemName' : item.itemName,
        'itemPrice' : item.itemPrice,
        'itemStatus' : item.itemStatus,
        'itemIntro' : item.itemIntro
      });
    }
  }, [item]);


  //마운트 됐을때 조회
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => {
      setItem(res.data)
    })
    .catch(e => console.log(e))
  }, []);

  //변경하는 값 넣어주는 함수
  const handleItem = (e) => {
    setUpdateItem({
      ...updateItem,
      [e.target.name] : e.target.value
    });
  }

  //버튼 누르면 수정함수
  const update = () => {
    axios.put(`/api/items/${itemNum}`, updateItem)
    .then(res => {
      alert('수정 완료')
      nav(`/detail/${itemNum}`);
    })
    .catch(e => console.log(e));
  }

  return (
    <div className={styles.container}>
      <div>
        상품 카테고리 <br />
        <select 
          name='itemCategory' value={updateItem.itemCategory}
          onChange={e => handleItem(e)}  
        >
          <option value=''>선택</option>
          <option value='상의'>상의</option>
          <option value='하의'>하의</option>
          <option value='액세사리'>액세사리</option>
        </select>
      </div>
      <div>
        상품명 <br />
        <input type="text" name='itemName' value={updateItem.itemName} onChange={e => handleItem(e)}/>
      </div>
      <div>
        상품 가격 <br />
        <input type="text" name='itemPrice' value={updateItem.itemPrice} onChange={e => handleItem(e)}/>
      </div>
      <div>
        상품 상태 <br />
        <input type="radio" name="itemStatus" value='준비중'
          onChange={e => handleItem(e)} checked={updateItem.itemStatus === '준비중'}/> 준비 중
        <input type="radio" name="itemStatus" value='판매중'
          onChange={e => handleItem(e)} checked={updateItem.itemStatus === '판매중'}/> 판매 중
        <input type="radio" name="itemStatus" value='매진'
          onChange={e => handleItem(e)} checked={updateItem.itemStatus === '매진'}/> 매진
      </div>
      <div>
        상품 소개 <br />
        <textarea cols={50} rows={7} name='itemIntro' value={updateItem.itemIntro} onChange={e => handleItem(e)}></textarea>
      </div>
      <div className={styles.btn_div}>
        <button type="button" onClick={e => nav(-1)}>취소</button>
        <button type="button" onClick={e => update()}>수정</button>
      </div>
    </div>
  )
}

export default UpdateForm