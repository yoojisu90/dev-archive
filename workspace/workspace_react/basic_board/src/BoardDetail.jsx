import React, { useState } from 'react'
import BoardList from './BoardList';
import axios from 'axios';

const BoardDetail = () => {
  //인풋태그에 입력한 데이터를 저장할 state 변수
  const [boardNum, setBoardNum] = useState('');
  
  //상세 조회 데이터를 저장할 state 변수
  const [boardDetail, setBoardDetail] = useState({});

  //표의 표시 여부를 저장하는 state 변수
  const [isShow, setIsShow] = useState(false);

  //조회 버튼 클릭 시 실행 함수
  const getDetail = () => {
    //표를 보이게 변경
    setIsShow(true);

    axios.get(`/api/boards/${boardNum}`)
    .then(res => {
      console.log(res.data);

      //없는 번호라면 (res.data가 빈 문자라면...)\
      if(res.data === ''){
        alert('없는 번호입니다');
        setIsShow(false);
      }
      setBoardDetail(res.data);
      
    })
    .catch(error => console.log(error))
  }


  return (
    <div>
      <h2>게시글 상세 정보 조회 페이지</h2>
      <p>
        조회할 게시글 번호를 입력하세요
        <input 
          type="text" name='boardNum'
          value={boardNum} onChange={(e)=>{
            setBoardNum(e.target.value);
          }}
         />
        <button type="button" onClick={(e)=>{
          getDetail();
        }}>조회</button>
      </p>
       {
        isShow &&
        <table border={1}>
          <tbody>
            <tr>
              <td>글번호</td>
              <td>{boardDetail.boardNum}</td>
              <td>조회수</td>
              <td>{boardDetail.readCnt}</td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>{boardDetail.writer}</td>
              <td>작성일자</td>
              <td>{boardDetail.createDate}</td>
            </tr>
            <tr>
              <td>제목</td>
              <td colSpan={3}>{boardDetail.title}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={3}>{boardDetail.content}</td>
            </tr>
          </tbody>
        </table>
      }  
    </div>
  )
}

export default BoardDetail