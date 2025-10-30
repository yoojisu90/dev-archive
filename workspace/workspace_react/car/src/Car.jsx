import React, { use, useEffect, useState } from 'react'
import styles from './Car.module.css'
import Input from './common/Input'
import Button from './common/Button'
import Select from './common/Select'
import axios from 'axios'

const Car = () => {
  //등록 후 조회를 위한 state변수
  const [reload, setReload] = useState(0);

  //차량 등록을 위한 state 변수
  const [addCar, setAddCar] = useState({});
  console.log(addCar)

  //차량 조회를 위한 state 변수
  const [carInfo, setCarInfo] = useState([]);

  //등록 버튼 활성화 여부를 저장할 state 변수
  const [isDisabled, setIsDisabled] = useState(true); 

  //마운트 or 차량 등록 조회시 차량 정보 조회
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarInfo(res.data))
    .catch(e => console.log(e))
  }, [reload]);

  //addCar가 변경되어 리렌더링되면 버튼 활성화 여부 변경
  useEffect(() => {
    //버튼 활성화 여부를 판단하여 disable 변경
    if(
      addCar.maker && addCar.maker !== '' && addCar.maker !== '선택' &&
      addCar.carName && addCar.carName !== '' &&
      addCar.price && addCar.price !== ''){
        setIsDisabled(false)
      }
    else{
      setIsDisabled(true)
    }  
  }, [addCar]);

  //addCar 정보를 바꾸는 함수
  const handleCar = (e) => {
    setAddCar({
      ...addCar,
      [e.target.name] : e.target.value
    })
  }

  //등록 버튼 누르면 등록 실행 함수
  const insertCar = () => {
    axios.post('/api/cars', addCar)
    .then(res => {
      alert('등록 성공');
      setAddCar({
        'maker' : '',
        'carName' : '',
        'price' : ''
      });
      setReload(reload +1);
    })
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <div>
        <h2>차량 등록</h2>
        <div className={styles.input}>
          <div>
            <p>제조사</p>
            <Select
              name='maker'
              value={addCar.maker ? addCar.maker : ''}
              onChange={(e) => {handleCar(e)}}  
            >
              <option value="">선택</option>
              <option value="현대">현대</option>
              <option value="기아">기아</option>
            </Select>
          </div>
          <div>
            <p>모델명</p>
            <Input
              size='200px'  
              name='carName'
              value={addCar.carName ? addCar.carName : '' }
              onChange={(e) => {handleCar(e)}}
            />
          </div>
          <div>
            <p>차량가격</p>
            <Input
              size='200px' 
              name='price'
              value={addCar.price ? addCar.price : ''}
              onChange={(e) => {handleCar(e)}}
            />
          </div>
        </div>
        <div className={styles.btn_div}>
          <Button 
            title='등록'
            onClick={e => insertCar()}
            disabled={isDisabled}
          />
        </div>
      </div>
      <div className={styles.table_div}>
        <h3>등록된 차량 목록</h3>
        <table>
          <colgroup>
            <col width='25%'/>
            <col width='25%'/>
            <col width='25%'/>
            <col width='25%'/>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>모델번호</td>
              <td>모델명</td>
              <td>제조사</td>
            </tr>
          </thead>
          <tbody>
          {
            carInfo.map((car, i) => {
              return(
                <tr key={i}>
                  <td>{carInfo.length - i}</td>
                  <td>{car.carNum}</td>
                  <td>{car.carName}</td>
                  <td>{car.maker}</td>
                </tr>
              )
            })
          }  
          </tbody>
        </table>
      </div>

    </div>
  )
}

export default Car