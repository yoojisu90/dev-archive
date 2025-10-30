import axios from 'axios';
import React, { useState } from 'react'
import BoardList from './BoardList';

const SearchBoardList = () => {
  //input 태그에 입력한 정보를 저장할 state 변수
  const [title, setTitle] = useState('');

  //조회된 데이터를 저장할 state 변수
  const [boardList, setBoardList] = useState([]);

  const [isShow, setIsShow] = useState(false);

  //조회 버튼 클릭 시 실행 함수'
  const goSearch = () => {
    setIsShow(true);

    axios.get(`/api/boards/search/${title}`)
    .then(res => {
      if(res.data === 0){
        setIsShow(false);
      }
      console.log(res.data);
      setBoardList(res.data);
    })
    .catch(error => console.log(error));
  }

  return (
    <div>
      <h3>게시글 목록 페이지2</h3>
      <div>
        <span>제목</span>
        <input 
          type="text" value={title} 
          onChange={e => setTitle(e.target.value)}
          onKeyDown={e => {
            console.log(e)
            if(e.key === "Enter"){
              goSearch();
            }
          }}
        />
        <button type="button" onClick={e => goSearch()}>조회</button>
      </div>
      {
        isShow &&

        <table border={1}>
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
            <td colSpan={5}>조회된 데이터가 없습니다</td>
            </tr>
            :
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
      
      }    
    </div>
  )
}

export default SearchBoardList