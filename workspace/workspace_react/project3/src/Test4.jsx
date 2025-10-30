import React, { useState } from 'react'
import './Test4.css'
const Test4 = () => {
  const [arr, setArr] = useState([0, 0, 0]);

  function changeNum(index){
    const copyArr = [...arr];
        copyArr[index] = copyArr[index] + 1;
        setArr(copyArr);
  }


  return (
    <div className='test4_container'>
      <div onClick={() => changeNum(0)}>{arr[0]}</div>
      <div onClick={() => changeNum(1)}>{arr[1]}</div>
      <div onClick={() => changeNum(2)}>{arr[2]}</div>
      
    </div>
  )
}

export default Test4