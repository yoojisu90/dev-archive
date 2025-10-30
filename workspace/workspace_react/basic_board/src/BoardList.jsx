import axios from 'axios';
import React, { useEffect, useState } from 'react'

const BoardList = () => {
  const [boardList, setBoardList] =useState([]);

  useEffect(() => {
    axios.get('api/boards')
    .then(res => {
      console.log(res.data);
      setBoardList(res.data);
    })
    .catch(error => console.log(error))
  }, []);

  
  return (
    <div>
      <h2>게시글 목록 페이지</h2>
      <p>총 {boardList.length}개의 게시글이 조회되었습니다</p>
      <table>
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
          boardList.map((board, i) => {
            return(
              <tr key={i}>
                <td>{boardList.length - i}</td>
                <td>{board.title}</td>
                <td>{board.writer}</td>
                <td>{board.createDate}</td>
                <td>{board.readCnt}</td>
              </tr>
            )
          })
        }
        </tbody>
      </table>
    </div>
  )
}

export default BoardList