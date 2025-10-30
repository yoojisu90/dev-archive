import React, { useEffect, useState } from 'react'
import Input from './common/Input'
import Button from './common/Button'
import Select from './common/Select'
import styles from './Sales.module.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const Sales = () => {
  const nav = useNavigate();

  //연락처 정규식 
  const phoneRegex = /^010-\d{4}-\d{4}$/;

  //에러 메세지를 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState('');

  //등록 버튼 활성화 여부를 저장할 state 변수
  const [isDisabled, setIsDisabled] = useState(true);

  //에러 메세지를 변경할 함수
  const handelErrorMsg = (e) => {
    switch(e.target.name){
      case 'phone' : 
        if(!phoneRegex.test(e.target.value) ){
          setErrorMsg('연락처는 010-xxxx-xxxx의 형태만 등록 가능합니다')
        }
        else{
          setErrorMsg('')
        }
        break;
    }
    return errorMsg;
  }

  //판매 정보 변경을 위한 state 변수
  const [salesInfo, setSalesInfo] = useState({});

  console.log(salesInfo);

  //마운트시 차량 모델 변경을 위한 state변수
  const [carName, setCarName] = useState([]);

  //마운트 했을때 차량 모델명 조회
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarName(res.data))
    .catch(e => console.log(e))
  }, []);

  //addCar가 변경되어 리렌더링되면 버튼 활성화 여부 변경
    useEffect(() => {
      //버튼 활성화 여부를 판단하여 disable 변경
      if(
        salesInfo.buyer && salesInfo.buyer !== '' &&
        salesInfo.color && salesInfo.color !== '' && salesInfo.color !== '선택' &&
        salesInfo.carNum && salesInfo.carNum !== '' && salesInfo.carNum !== '선택'
        ){
          setIsDisabled(false)
        }
      else{
        setIsDisabled(true)
      }  
    }, [salesInfo]);

  //값 변경 함수
  const handleSales = (e) => {
    setSalesInfo({
      ...salesInfo,
      [e.target.name] : e.target.value
    })
  }

  //등록 버튼 눌렀을 때 실행함수
  const regSales = () => {
    axios.post('/api/sales', salesInfo)
    .then(res => {
      alert('판매 등록 성공')
      setSalesInfo({
        'buyer' : '',
        'color' : '',
        'carNum' : '',
        'phone' : ''
      })
      nav('/sales-list');
    })
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <h2>판매 정보 등록</h2>
      <div className={styles.content}>
        <p>구매자명</p>
        <Input 
          size='200px'
          name='buyer'
          value={salesInfo.buyer ? salesInfo.buyer : ''}
          onChange={(e) => handleSales(e)}
        />
      </div>
      <div className={styles.content}>
        <div>
          <p>색상</p>
          <Select
            name='color'
            value={salesInfo.color}
            onChange={(e) => handleSales(e)}
          >
            <option>선택</option>
            <option>화이트</option>
            <option>블랙</option>
            <option>레드</option>
          </Select>
        </div>
        <div >
          <p>모델</p>
          <Select
            name='carNum'
            value={salesInfo.carNum}
            onChange={(e) => handleSales(e)}
          >
            <option>선택</option>
          {
          carName.map((e, i) => {
            return(
              <option key={i} value={e.carNum}>
                {e.carName}
              </option>
            )
          })    
          }
          </Select>
        </div>
      </div>
      <div className={styles.content}>
        <p>연락처</p>
        <Input 
          size='200px'
          name='phone'
          value={salesInfo.phone ? salesInfo.phone : ''}
          onChange={(e) => {
            handleSales(e)
            handelErrorMsg(e)
          }}  
        />
        <p className={styles.error}>{errorMsg}</p>
      </div>
      <div>
        <Button 
          title='등록'
          onClick={e => regSales()}
          disabled={isDisabled}
        />
      </div>
    </div>
  )
}

export default Sales