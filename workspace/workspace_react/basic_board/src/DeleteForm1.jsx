import axios from 'axios';
import React, { useState } from 'react'

const DeleteForm1 = () => {
  const [boardNum, setBoardNum] = useState('');

  console.log(boardNum);
  
  const deleteBoard= () => {
    axios.delete(`/api/boards/${boardNum}`)
    .then(res => {
      res.data === 0 ? alert('일치하는 글번호가 없습니다') : alert('정상적으로 삭제되었습니다');
    })
    .catch(error => console.log(error))
  }


  return (
    <div>
      <h3>게시글 삭제1</h3>
      글번호 
      <input 
        type="text" name='boardNum'
        value={boardNum} onChange={e => setBoardNum(e.target.value)}/> <br />

      <button type="button" onClick={(e)=>{deleteBoard()}}>삭제</button>
    </div>
  )
}

export default DeleteForm1