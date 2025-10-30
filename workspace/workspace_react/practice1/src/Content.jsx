import React from 'react'

const Content = () => {
  return (
    <>
      <hr />
      <div>
        <h3>개인정보</h3>
        <div className='d1'>
          <span>이름</span> <input type="text" placeholder='공백없이 입력하세요.'/> <br />
          <span>연락처</span> <input type="text" />
        </div>
      </div>
      <div>
        <h3>지원분야</h3>
        <div className='d1'>
          <input type="radio" name="a" id="" /> 웹퍼블리싱 <br />
          <input type="radio" name="a" id="" /> 웹 프론트앤드 <br />
          <input type="radio" name="a" id="" /> 모바일 앱
        </div>
      </div>
      <div>
        <h3>지원동기</h3>
        <p><textarea rows='5' cols='60'></textarea></p>
      </div>
    </>
    
  )
}

export default Content