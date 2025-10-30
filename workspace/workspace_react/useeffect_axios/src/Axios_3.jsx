import axios from 'axios'
import React, { useEffect, useState } from 'react'

const Axios_3 = () => {
  //status 변수의 초기값은 최종데이터의 자료형과 일치시켜주는게 좋음!
  const [stu, setStu] = useState({});

  useEffect(()=>{
    axios.get('/api/getStu')
    .then((res) => {
      console.log(res.data);
      setStu(res.data);
    })
    .catch((error) => {
      console.log(error);
    });
  }, []);

  //자바에서 전달받은 학생의 이름, 국어, 영어 정보를 화면에 표현하시오.
  return (
    <>
      <div>이름 : {stu.name} </div>
      <div>국어 : {stu.korScore}</div>
      <div>영어 : {stu.engScore}</div>
    </>
   
  )
}

export default Axios_3