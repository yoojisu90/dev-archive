import React, { useEffect, useState } from 'react'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import { handleErrorMsg } from '../validate/bookValidate'
import styles from './RegBook.module.css'

const RegBook = () => {
  //입력 안하면 회원가입 버튼 비활성화 state변수
  const [isDisabled, setIsDisabled] = useState(true);


  //유효성 검사 결과 에러 메세지를 저장할 state변수
  const [errorMsg, setErrorMsg] = useState({
    'cateNum' : '카테고리를 선택하세요',
    'title' : '제목은 필수입력입니다',
    'publisher' : '출판사는 필수입력입니다',
    'price' : '가격은 필수입력입니다'
  });
  
  //카테고리 조회를 받는 state변수 
  const [category, setCategory] = useState([]);

  //도서 등록을 할 state변수
  const [book, setBook] = useState({
    'cateNum' : '',
    'title' : '',
    'publisher' : '',
    'price' : '',
    'bookIntro' : ''
  });

  console.log(book);

  //인풋 입력했을때 값 변경하는 함수
  const handleBookData = (e) => {
    //만약 가격 데이터가 들어왔다면 천단위 구분기호를 제외한다.
    setBook({
      ...book,
      [e.target.name] : e.target.name === 'price' ? e.target.value.replaceAll(',' , '') : e.target.value
    })
  }

  //마운트시 카테고리 조회
  useEffect(() => {
    axios.get('/api/categories')
    .then(res => setCategory(res.data))
    .catch(e => console.log(e))
  }, []);

  //마운트되거나, bookData가 변경되어 리렌더링 되면 버튼 활성화 여부 변경
  useEffect(() => {
    //필수 입력 항목에 입력이 되고 유효성 검사 통과되면 등록버튼 활성화
    if(
      book.cateNum !== '' &&
      book.title !== '' &&
      book.price !== '' &&
      book.publisher !== '' &&
      errorMsg.cateNum == '' &&
      errorMsg.title == '' &&
      errorMsg.price == '' &&
      errorMsg.publisher == ''
    ){
      setIsDisabled(false)
    }
    else{
      setIsDisabled(true)
    }
  }, [book]);

  //등록 버튼 눌렀을때 실행 함수
  const regBook = () => {
    axios.post('/api/books', book)
    .then(res => {
      alert('등록완료!');
      setBook({
        'cateNum' : '',
        'title' : '',
        'publisher' : '',
        'price' : '',
        'bookIntro' : ''
      });
      setIsDisabled(true);
    })
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <h2>도서 등록</h2>
      <div className={styles.content}>
        <div>
          <p>도서 카테고리</p>
          <Select
            size='250px'
            name='cateNum'
            value={book.cateNum}
            onChange={e=> {
              handleBookData(e)
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'cateNum' : handleErrorMsg(e)
              });
            }}
          >
            <option value=''>카테고리 선택</option>
            {
            category.map((e,i) => {
              return(
                <option value={e.cateNum} key={i}>{e.cateName}</option>
              )
            })
            
            }
          </Select>
          <p className={styles.msg}>{errorMsg.cateNum}</p>
        </div> 
        <div>
          <p>도서명</p>
          <Input 
            size='250px'
            name='title'
            value={book.title}
            onChange={e=> {
              handleBookData(e)
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'title' : handleErrorMsg(e)
              });
            }}
          />
          <p className={styles.msg}>{errorMsg.title}</p>
        </div> 
        <div>
          <p>출판사</p>
          <Input 
            size='250px'
            name='publisher'
            value={book.publisher}
            onChange={e=> {
              handleBookData(e)
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'publisher' : handleErrorMsg(e)
              }); 
            }}
          />
          <p className={styles.msg}>{errorMsg.publisher}</p>  
        </div> 
        <div>
          <p>가격</p>
          <Input 
            size='250px'
            name='price'
            value={
              book.price === '' ? book.price : parseInt(book.price).toLocaleString()
            }
            onChange={e=> {
              handleBookData(e)
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'price' : handleErrorMsg(e)
              }); 
            }}
          />
          <p className={styles.msg}>{errorMsg.price}</p>
        </div>
        <div>
          <p>메인 이미지</p>
          <input type="file" name="" id="" />
        </div>
        <div>
          <p>도서 설명</p>
          <textarea
            className={styles.textarea}
            name='bookIntro'
            value={book.bookIntro}
            onChange={e=>handleBookData(e)}
          />
        </div>
        <Button
          size='250px'
          title='등록'
          onClick={()=>regBook()}  
          disabled={isDisabled}
        />
      </div>
      </div>
  )
}

export default RegBook