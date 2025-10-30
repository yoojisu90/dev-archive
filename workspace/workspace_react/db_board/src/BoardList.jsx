import axios from 'axios';
import React, { useEffect, useState } from 'react'
import styles from './BoardList.module.css';
import { useNavigate } from 'react-router-dom';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);

  const nav = useNavigate();
  
  useEffect(() => {
    axios.get('/api/boards')
    .then(res => {
      console.log(res.data);
      setBoardList(res.data);
    })
    .catch(error => console.log(error))
  }, []);
  
  
  
  return (
    <div className={styles.list_container}>
      <h1>자유게시판</h1>
      <div className={styles.search}>
        <select>
          <option>제목</option>
          <option>작성자</option>
        </select>
        <input type="text" />
        <button type="button">검색</button>
      </div>
      <table className={styles.list_table}>
        <colgroup>
          <col style={{ width: '10%' }} />
          <col style={{ width: '35%' }} />
          <col style={{ width: '10%' }} />
          <col style={{ width: '35%' }} />
          <col style={{ width: '10%' }} />
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>조회수</td>
          </tr>
        </thead>
        <tbody>
        {
          boardList.length === 0
          ?
          <tr>
            <td colSpan={5}>조회된 게시글이 없습니다</td>
          </tr>
          :
          boardList.map((board, i) => {
            return(
              <tr key={i}>
                <td>{boardList.length - i}</td>
                <td onClick={e => {
                  nav(`/detail/${board.boardNum}`);
              }}><span>{board.title}</span></td>
                <td>{board.writer}</td>
                <td>{board.createDate}</td>
                <td>{board.readCnt}</td>
              </tr>
            )
          })
        }
        </tbody>
      </table>

      <button type="button" onClick={e => nav('/insert')}>글쓰기</button>
    </div>
  )
}

export default BoardList