import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import styles from './RegForm.module.css'

const RegForm = () => {
  const [regItem, setRegItem] = useState({
    'itemCategory' : '',
    'itemName' : '',
    'itemPrice' : '',
    'itemStatus' : '준비중',
    'itemIntro' : ''
  });

  //유효성 검사에 사용할 변수
  const [isNotValid, setIsNotValid] = useState({
    'itemCategory' : false,
    'itemName' : false,
    'itemPrice' : false
  });

  const nav = useNavigate();

  console.log(regItem)
  const handleItem = (e) => {
    setRegItem({
      ...regItem,
      [e.target.name] : e.target.value
    });
  }

  const reg = () => {
    //유효성 함수 호출
    const result = checkValid();

    if(result){
      axios.post('/api/items', regItem)
      .then(res => {
        alert('아이템이 등록되었습니다. \n상품 목록 페이지로 이동합니다.')
        nav('/');
      })
      .catch(e => console.log(e))
    }
  }

  //유효성 검사 함수
  const checkValid = () => {
    //유효성 검사 결과
    const isValid = true;

    //유효성 검사(상품명)
    if(regItem.itemName === ''){
      setIsNotValid({
        ...isNotValid,
        'itemName' : true
      })
      isValid = false;
    }

    //유효성 검사(카테고리)
    if(regItem.itemCategory === ''){
      setIsNotValid({
        ...isNotValid,
        'itemCategory' : true
      })
      isValid = false;
    }

    //유효성 검사(가격)
    if(regItem.itemPrice === '' || regItem.itemPrice < 0){
      setIsNotValid({
        ...isNotValid,
        'itemPrice' : true
      })
      isValid = false;
    }
    return isValid;
  }

  return (
    <div className={styles.container}>
      <div>
        상품 카테고리 <br />
        <select 
          name='itemCategory' value={regItem.itemCategory} 
          onChange={e => handleItem(e)}>
          <option value=''>선택</option>
          <option value='상의'>상의</option>
          <option value='하의'>하의</option>
          <option value='액세사리'>액세사리</option>
        </select>
        {
          isNotValid.itemCategory &&
          <p className={styles.not_valid}>상품카테고리를 선택해주세요</p>  
        }  
      </div>
      <div>
        <p>상품명</p>
        <input 
          type="tex" name='itemName'
          value={regItem.itemName} onChange={e => handleItem(e)}/>
        {
          isNotValid.itemName &&
          <p className={styles.not_valid}>상품명은 필수입력입니다</p>  
        }  
        
      </div>
      <div>
        <p>상품 가격</p>
        <input 
          type="text" name='itemPrice'
          value={regItem.itemPrice} onChange={e => handleItem(e)}/>
        {
          isNotValid.itemPrice &&
          <p className={styles.not_valid}>상품가격은 필수입력이며, 음수가 들어올 수 없습니다</p>  
        }  
      </div>
      <div>
        <p>상품 상태</p>
        <input type="radio" 
          name="itemStatus" value='준비중'
          onChange={e => handleItem(e)} checked={regItem.itemStatus === '준비중'}/> 준비중
        <input type="radio" 
          name="itemStatus" value='판매중'
          onChange={e => handleItem(e)} checked={regItem.itemStatus === '판매중'}/> 판매중
        <input type="radio" 
          name="itemStatus" value='매진'
          onChange={e => handleItem(e)} checked={regItem.itemStatus === '매진'}/> 매진
      </div>
      <div>
        상품 소개 <br />
        <textarea
          name="itemIntro" value={regItem.itemIntro}
          onChange={e => handleItem(e)}></textarea>
      </div>
      <div className={styles.btn_div}>
        <button type="button" onClick={() => reg()}>등록</button>
      </div>
     
    </div>
  )
}

export default RegForm