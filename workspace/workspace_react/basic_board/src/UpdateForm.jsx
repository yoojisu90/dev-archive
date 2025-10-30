import axios from 'axios';
import React, { useState } from 'react'

const UpdateForm = () => {
  const [boardData, setBoardData] = useState({
    'boardNum' : '',
    'title' : '',
    'content' : ''
  });

  console.log(boardData);

  const handleBoardData = (e) => {
    setBoardData({
      ...boardData,
      [e.target.name] : e.target.value
    });
  }

  const updateBoard = () => {
    axios.put(`/api/boards/${boardData.boardNum}`, boardData)
    .then(res => {
      alert(`${res.data}개의 게시글이 수정되었습니다`);
    })
    .catch(error => console.log(error));
  }


  return (
    <div>
      <h3>게시글 정보 수정</h3>
      글번호 <input 
        type="text" name='boardNum' 
        value={boardData.boardNum} onChange={e => handleBoardData(e)}/> <br />
      
      제목 <input 
        type="text" name='title'
        value={boardData.title} onChange={e => handleBoardData(e)}/> <br />
      
      내용 <textarea 
        cols={50} rows={5} name='content'
        value={boardData.content} onChange={e => handleBoardData(e)}
      ></textarea> <br />
      
      <button type="button" onClick={(e) => {updateBoard()}}>수정</button>

    </div>
  )
}

export default UpdateForm