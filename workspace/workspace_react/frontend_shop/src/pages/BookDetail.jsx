import React, { useEffect, useState } from 'react'
import Button from '../common/Button'
import Input from '../common/Input'
import styles from './BookDetail.module.css'
import axios from 'axios'
import { useNavigate, useParams } from 'react-router-dom'

const BookDetail = () => {
  const {bookNum} = useParams();
  const nav = useNavigate();

  //장바구니 데이터를 변경할 state 변수
 
  //갯수 변화를 위한 state 변수
  const [cnt, setCnt] = useState(1);

  //도서 상세정보 변경을 위한 state 변수
  const [bookDetail, setBookDetail] = useState({});

  console.log(bookDetail)

  //마운트 했을때 상세정보 조회
  useEffect(() => {
    axios.get(`/api/books/${bookNum}`)
    .then(res=>setBookDetail(res.data))
    .catch(e => console.log(e))
  }, []);

  //로그인한 회원의 id
  const loginInfo = sessionStorage.getItem('loginInfo')
  const result = JSON.parse(loginInfo);

  //장바구니 눌렀을떄 장바구니 추가 함수
  const addCart = () => {
    //로그인 안했으면
    if(sessionStorage.getItem('loginInfo') === null){
      alert('로그인 필수!')
      return;
    }
    axios.post('/api/carts', {
      'bookNum' : bookNum,
      'cartCnt': cnt,
      'memId' : result.memId
    })
    .then(res => {
      const result = confirm('장바구니에 상품을 담았습니다.\n장바구니 페이지로 이동할까요?');
      if(result){
        //장바구니 페이지로 이동
        nav('/user/cart-list');
      }
    })
    .catch(e => console.log(e))
  }

  //구매하기 버튼 클릭 시 insert하는 함수
  const addBuy = () => {
    //로그인 안했으면
    if(sessionStorage.getItem('loginInfo') === null){
      alert('로그인 필수!')
      return;
    }
    axios.post('/api/buys', {
      'bookNum' : bookNum,
      'buyCnt': cnt,
      'memId' : result.memId
    })
    .then(res => {
      if(res.status === 201){
        alert('구매 성공');
      }
    })
    .catch(e => {
      console.log(e)
      alert(e.response.data);
    })
  }

  return (
    <div>
      <div className={styles.container}>
        <div className={styles.main}>
          <div>
          {
            bookDetail.imgList && bookDetail.imgList.map((e, i) => {
              return(
              e.isMain === 'Y' &&
              <img key={i} 
                src={`http://localhost:8080/upload/${e.attachedImgName}`}/>)
            })
          }  
          </div>
          <div className={styles.list}>
            <p>{bookDetail.title}</p>
            <p>{bookDetail.publisher}</p>
            <p>{bookDetail.price && bookDetail.price.toLocaleString()}</p>
            <Input
              min='1' 
              type='number'
              value={cnt}
              onChange={e=>{
                setCnt(e.target.value)
              }}
            />
            <p>{bookDetail.price && (bookDetail.price * cnt).toLocaleString()}</p>
            <div className={styles.btn_div}>
              <Button 
                size='50%' 
                title='장바구니' 
                color='green'
                onClick={e => addCart()}  
              />
              <Button
                size='50%' 
                title='구매하기'
                onClick={e => addBuy()}
              />
            </div>
          </div>
        </div>
        <div className={styles.intro_div}>
          <p>{bookDetail.bookIntro}</p>
        </div>
      </div>
      <div className={styles.img_div}>
      {
        bookDetail.imgList && bookDetail.imgList.map((e, i) => {
          return(
          e.isMain === 'N' &&
          <img key={i} 
            src={`http://localhost:8080/upload/${e.attachedImgName}`}/>)
        })
      }  
    
      </div>
    </div>
  )
}

export default BookDetail