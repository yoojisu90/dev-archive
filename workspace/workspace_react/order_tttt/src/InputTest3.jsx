import axios from 'axios';
import React, { useState } from 'react'

const InputTest3 = () => {
  const [classInfo, setClassInfo] = useState({
    'name' : '',
    'korScore' : 0,
    'engScore' : 0,
    'addr' : ''
  });

  const regClass = () => {
    axios.post('/api/class', classInfo)
    .then(res=>console.log(res.data))
    .catch(error=>console.log(error));
  };

  return (
    <div>
      이름 : <input value={classInfo.name} type="text" onChange={(e)=>{
        setClassInfo({...classInfo, 'name' : e.target.value});
      }}/> <br />
      국어점수 : <input value={classInfo.korScore} type="text" onChange={(e)=>{
        setClassInfo({...classInfo, 'korScore' : e.target.value});
      }}/> <br />
      영어점수 : <input value={classInfo.engScore} type="text" onChange={(e)=>{
        setClassInfo({...classInfo, 'engScore' : e.target.value});
      }}/> <br />
      주소 : <input value={classInfo.addr} type="text" onChange={(e)=>{
        setClassInfo({...classInfo, 'addr' : e.target.value});
      }}/> <br />

      <button type="button" onClick={e=>regClass()}>등록</button>
    </div>
  )
}

export default InputTest3