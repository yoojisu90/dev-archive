import React, { useState } from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Join.module.css'
import axios from 'axios'
import Select from '../common/Select'
import { handleErrorMsg } from '../validate/joinValidate'
import { useDaumPostcodePopup } from 'react-daum-postcode'

const Join = ({isOpenJoin, onClose}) => {
  //다음 주소록 팜업 생성 함수
  const open = useDaumPostcodePopup('//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js');

  //주소록 띄우기 함수
  const handlePost= () => {
    open({onComplete : (data) => {
      //매개변수 data 안에 선택한 주소의 모든 정보가 객체형태로 들어있음
      setJoinData({
        ...joinData,
        'memAddr' : data.address
      });
    }})
  }

  //유효성 검사결과 에러 메시지를 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState({
    'memId' : '',
    'memPw' : '',
    'confirmPw' : ''
  });

  //회원가입 버튼 사용 가능 여부를 저장하는 state 변수
  const [isDisable, setIsDisable] = useState(true);

  //회원가입 시 입력한 내용을 저장할 state 변수
  const [joinData, setJoinData] = useState({
    'memId' : '',
    'memPw' : '',
    'confirmPw' : '',
    'memName' : '',
    'memTelArr' : ['','',''],
    'firstEmail' : '',
    'secondEmail' : '',
    'memEmail' : '',
    'memAddr' : '',
    'addrDetail' : ''
  });
  
  //값 입력시 실행할 함수
  const handleJoinData = (e) => {
    //이메일을 변경했으면
    if(e.target.name === 'firstEmail' || e.target.name === 'secondEmail'){
      setJoinData({
      ...joinData,
      [e.target.name] : e.target.value, //'firstEmail' : 'java'
      'memEmail' : e.target.name === 'firstEmail'
                    ? 
                    e.target.value + joinData.secondEmail  
                    :
                    joinData.firstEmail + e.target.value
    })
    }

    //이메일을 제외한 다른 데이터를 변경했으면
    else{
      setJoinData({
        ...joinData,
        [e.target.name] : e.target.value
      })
    }
    
  }
  
  //joinData 확인용
  //console.log(joinData)

  //연락처 변경 시 실행 함수
  const handleMemTel = (e, index) => {
    joinData.memTelArr.splice(index, 1, e.target.value);

    setJoinData({
      ...joinData,
      'memTelArr' : joinData.memTelArr
    })
  }

  //회원가입 버튼 클릭시 실행 함수
  const join = () => {
    axios.post('/api/members', joinData)
    .then(res => {
      alert('회원가입 성공');
      
      //모달창을 닫음
      onClose();

      //입력한 값을 초기화
        setJoinData({
          'memId' : '',
          'memPw' : '',
          'confirmPw' : '',
          'memName' : '',
          'memTelArr' : ['','',''],
          'firstEmail' : '',
          'secondEmail' : '',
          'memEmail' : '',
          'memAddr' : '',
          'addrDetail' : ''
        });

    })
    .catch(e => console.log(e))
  }

  //아이디 사용 가능 여부 확인 함수
  const checkId = () => {
    axios.get(`/api/members/checkId/${joinData.memId}`)
    .then(res => {
      if(res.data){
        alert('사용 가능')

        //회원가입 버튼 활성화
        setIsDisable(false);
      }
      else{
        alert('사용 불가능')
        setIsDisable(true);
      }
    })
    .catch(e => console.log(e))
  }
   

  return (
    <Modal
      isOpen={isOpenJoin}
      size='300px'
      title='회원가입'
      onClose={() => {
        //X 버튼 클릭 시 회원가입 버튼 비활성화
        setIsDisable(true);

        //X 버튼 클릭 시 모달을 닫히게 하는 함수
        onClose();

        //입력한 값을 초기화
        setJoinData({
          'memId' : '',
          'memPw' : '',
          'confirmPw' : '',
          'memName' : '',
          'memTelArr' : ['','',''],
          'firstEmail' : '',
          'secondEmail' : '',
          'memEmail' : '',
          'memAddr' : '',
          'addrDetail' : ''
        }); 

        //validation error 메세지 초기화
        setErrorMsg({
          ...errorMsg,
          'memId' : '',
          'memPw' : '',
          'confirmPw' : ''
        });
       
        
      }}
    >
      <div className={styles.join_container}>
        <div>
          <p>아이디</p>
          <div className={styles.id_input}>
            <Input 
              size='70%'
              name='memId'
              value={joinData.memId}
              onChange={e=> {
                handleJoinData(e)
                setIsDisable(true);

                //유효성 결과 세팅
                setErrorMsg({
                  ...errorMsg,
                  'memId' : handleErrorMsg(e)
                });
              }}
            />
            <Button 
              size='30%' 
              title='중복확인'
              onClick={()=>checkId()} 
            />
          </div>
          <p className={styles.error}>{errorMsg.memId}</p>
        </div>
        <div>
          <p>비밀번호</p>
          <Input 
            size='100%'
            type='password'
            name='memPw'
            value={joinData.memPw}
            onChange={e=> {
              handleJoinData(e)
              
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'memPw' : handleErrorMsg(e)
              });

            }}
          />
          <p className={styles.error}>{errorMsg.memPw}</p>
        </div>
        <div>
          <p>비밀번호 확인</p>
          <Input 
            size='100%'
            type='password'
            name='confirmPw'
            value={joinData.confirmPw}
            onChange={e=> {
              handleJoinData(e)
              //유효성 검사
              setErrorMsg({
                ...errorMsg,
                'confirmPw' : handleErrorMsg(e, joinData)
              });
            }}
          />
          <p className={styles.error}>{errorMsg.confirmPw}</p>
        </div>
        <div>
          <p>회원명</p>
          <Input 
            size='100%'
            name='memName'
            value={joinData.memName}
            onChange={e=>handleJoinData(e)}
          />
        </div>
        <div>
          <p>연락처</p>
          <div className={styles.tel_input}>
            <Input 
              size='100%'
              name='memTelArr'
              value={joinData.memTelArr[0]}
              onChange={e=> handleMemTel(e, 0)}  
            />
            <Input 
              size='100%'
              name='memTelArr'
              value={joinData.memTelArr[1]}
              onChange={e=> handleMemTel(e, 1)}
            />
            <Input 
              size='100%'
              name='memTelArr'
              value={joinData.memTelArr[2]}
              onChange={e=> handleMemTel(e, 2)} 
            />
          </div>
        </div>
        <div>
          <p>이메일</p>
          <div className={styles.email_input}>
            <Input size='100%'
              name='firstEmail'
              value={joinData.firstEmail}
              onChange={e=>handleJoinData(e)}
            />
            <Select size='120px' 
              name='secondEmail'
              value={joinData.secondEmail}
              onChange={e=>handleJoinData(e)}
            >
              <option value=''>전체</option>
              <option value='@gmail.com'>@gmail.com</option>
              <option value='@naver.com'>@naver.com</option>
            </Select>
          </div>
        </div>
        <div>
          <p>주소</p>
          <div className={styles.addr_input}>
            <Input 
              size='70%'
              name='memAddr'
              value={joinData.memAddr}
              onChange={e=>handleJoinData(e)}
              readOnly={true} //읽기전용
              onClick={()=>handlePost()}
            />
            <Button 
              size='30%'
              title='검 색'
              onClick={()=>handlePost()}
            />
          </div>
          <div>
            <Input 
              size='100%'
              name='addrDetail'
              value={joinData.addrDetail}
              onChange={e=>handleJoinData(e)}
            />
          </div>
        </div>
        <div>
          <Button
            title='회원가입'
            size='100%'
            onClick={() => join()}
            disabled={isDisable} //처음엔 사용 불가
          />
        </div>
      </div>
    </Modal>
  )
}

export default Join