import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import styles from './BoardDetail.module.css'

const BoardDetail = () => {
  const [board, setBoard] = useState({});
  
  const {boardNum} = useParams();
  
  const nav = useNavigate();

  //동시에 실행하는 것 => 비동기
  //컴포넌트가 마운트되면 조회수를 1증가 시킨다
  useEffect(() => {
    axios.put(`/api/boards/read-cnt/${boardNum}`)
    .then(res => getBoardDetail())
    .catch(error => console.log(error))
  }, []);
  
  //상세정보 조회 함수
  const getBoardDetail = () => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => {
      console.log(res.data);
      setBoard(res.data);
    })
    .catch(error => console.log(error))
  }
  
  //게시글 삭제 함수
  const goDelete = (e) => {
    //confirm에서 확인 클릭 시 리턴 true
    const result = confirm('정말 삭제할까요?')

    //확인을 클릭했을 때만 삭제 진행
    if(result){
      axios.delete(`/api/boards/${boardNum}`)
      .then(res => alert(`${boardNum}번의 게시글 삭제 완료`))
      .catch(error => console.log(error))
    }
  }


  return (
    <div className={styles.detail_container}>
      <h1>게시글 상세 정보 페이지</h1>
      <table className={styles.detail_table}>
        <colgroup>
          <col style={{ width: '15%' }} />
          <col style={{ width: '25%' }} />
          <col style={{ width: '15%' }} />
          <col style={{ width: '15%' }} />
          <col style={{ width: '15%' }} />
          <col style={{ width: '15%' }} />
        </colgroup>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{board.createDate}</td>
            <td>작성자</td>
            <td>{board.writer}</td>
            <td>조회수</td>
            <td>{board.readCnt}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={5} className={styles.text}>{board.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={5} className={styles.text}>{board.content}</td>
          </tr>
        </tbody>
      </table>

      <button type="button" onClick={e => nav('/')}>목록가기</button>
      <button type="button" 
        onClick={e => {
          nav(`/update/${board.boardNum}`)
        }}>수정</button>

      <button type="button" 
        onClick={e => {
          goDelete(e);
          nav(`/`)
        }}>삭제</button>
    </div>
  )
}

export default BoardDetail