import axios from 'axios';
import React, { use, useState } from 'react'

const MemberRegForm = () => {
  const [regForm, setRegForm] = useState({
    'memId' : '',
    'memPw' : '',
    'checkPw' : '',
    'memName' : '',
    'memAge' : ''
  });

  console.log(regForm);

  const handleRegForm = (e) => {
    setRegForm({
      ...regForm,
      [e.target.name] : e.target.value
    });
  }

  const formMember = () => {
    regForm.checkPw !== regForm.memPw 
    ? 
    alert('비밀번호를 확인하세요') 
    : 
    axios.post('/api/forms', regForm)
    .then(res => alert('회원가입 완료!'))
    .catch(error => console.log(error));
  }

  // const formMember = () => {
  //   if(regForm.checkPw !== regForm.memPw){
  //     alert('비밀번호를 확인하세요')
  //     return ;
  //   }

  //   axios.post('/api/forms', regForm)
  //   .then(res => alert('회원가입 완료!'))
  //   .catch(error => console.log(error));
  // }

  return (
    <div>
      <h3>회원등록</h3>
      아이디 
      <input 
        type="text" name='memId' 
        value={regForm.memId} onChange={e => handleRegForm(e)}/> <br />
      
      비번 
      <input 
        type="password" name='memPw' 
        value={regForm.memPw} onChange={e => handleRegForm(e)}/> <br />
      
      비번확인 
      <input 
        type="password" name='checkPw' 
        value={regForm.checkPw} onChange={e => handleRegForm(e)}/> <br />
      
      이름 
      <input 
        type="text" name='memName' 
        value={regForm.memName} onChange={e => handleRegForm(e)}/> <br />
      
      나이 
      <input 
        type="text" name='memAge' 
        value={regForm.memAge} onChange={e => handleRegForm(e)}/> <br />
      
      <button type="button" onClick={e => formMember()}>회원가입</button>
    </div>
  )
}

export default MemberRegForm