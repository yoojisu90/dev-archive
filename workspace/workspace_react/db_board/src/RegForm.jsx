import axios from 'axios';
import React, { useState } from 'react'
import styles from './RegForm.module.css'
import { useNavigate } from 'react-router-dom';

const RegForm = () => {
  const [insertBoard,setInsertBoard] = useState({
    'title' : '',
    'writer' : '',
    'content' : ''
  });

  const nav = useNavigate();

  console.log(insertBoard)

  const handleBoard = (e) => {
    setInsertBoard({
      ...insertBoard,
      [e.target.name] : e.target.value
    });
  }

  const regBoard = () => {
    insertBoard.title === '' || insertBoard.writer === '' ?
    alert('제목과 작성자는 필수 입력입니다')
    :
    axios.post('/api/boards', insertBoard)
    .then(res => {
      alert('게시글이 등록되었습니다.\n게시글 목록페이지로 이동합니다.')
      nav('/');
    })
    .catch(error => console.log(error))
  }

  return (
    <div className={styles.reg_container}>
      <h1>게시글 작성 페이지</h1>
      <table className={styles.reg_table}>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              <input 
                type="text" name='title' value={insertBoard.title}
                onChange={e => handleBoard(e)}/></td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input 
                type="text" name='writer' value={insertBoard.writer}
                onChange={e => handleBoard(e)}/>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <textarea cols={50} rows={7} 
                name='content' value={insertBoard.content}
                onChange={e => handleBoard(e)}
              ></textarea>
            </td>
          </tr>
        </tbody>
      </table>

      <button type="button" onClick={()=>{
        regBoard()
      }}>글등록</button>
    </div>
  )
}

export default RegForm