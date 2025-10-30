import React from 'react'

const CallbackTest = () => {

  const test = (a, b) => {
    alert(a + b);
  }

  return (
    <div>
      {/* 함수의 참조값을 onClick에 저장 */}
      <button type="button" onClick={() => test(10,20)}>버튼1</button>
      <button type="button" onClick={test}>버튼2</button> 

      {/* test()함수의 실행 후 리턴값이 onClick에 저장 */}
      {/* <button type="button" onClick={test()}>버튼3</button> */}
    </div>
  )
}

export default CallbackTest