import React, { useState } from 'react'

const InputTest4 = () => {
  const man = {
    name : 'kim',
    age : 20
  }

  const v = 'age';
  man.v //man.v -> v라는 키에 대한 value값 가져오겠습니다 => undefined
  man[v]; //man['age'] => 20

  console.log(man.name);
  console.log(man.age);
  console.log(man['name']);
  console.log(man['age']);


  //input 태그에 입력한 모든 내용을 저장하기 위한 state 변수
  const [inputData, setInputData] =useState({
    'name' : '',
    'age' : '',
    'addr' : ''
  });

  console.log(inputData);

  //input 태그에 값을 입력할 때마다 실행시키는 함수
  const handleInputData = (e) => {
    setInputData({
      ...inputData,
      [e.target.name] : e.target.value
    })
  }

  return (
    <div>
      이름
      <input 
        name="name"
        type="text" 
        value={inputData.name} 
        onChange={e => handleInputData(e)
      }/> <br />
      나이 
      <input 
        name='age'
        type="text" 
        value={inputData.age} 
        onChange={e => handleInputData(e)
      }/> <br />
      주소 
      <input 
        name='addr'
        type="text" 
        value={inputData.addr} 
        onChange={e => handleInputData(e)
      }/> <br />
    </div>
  )
}

export default InputTest4