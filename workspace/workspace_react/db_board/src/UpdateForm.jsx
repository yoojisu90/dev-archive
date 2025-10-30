import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import styles from './UpdateForm.module.css'

const UpdateForm = () => {
  //URL로 전달되는 글 번호
  const {boardNum} = useParams();
 
  const nav = useNavigate();

  //조회한 정보를 저장할 state 변수
  const [board, setBoard] = useState({});

  //입력한 제목과 내용을 저장할 state 변수
  const [inputData, setInputData] = useState({
    'title' : '',
    'content' : ''
  });
  
  //board가 값이 바뀔 때만 실행! + 마운트 시에도 실행 x
  //의존성 배열에 board를 넣으면 board값이 바뀌어서 리렌더링 될때도 실행!
  useEffect(() => {
    //마운트 시점이 아니라면
    //if(board.title !== undefined){
    if(Object.keys(board) !== 0 ){
      setInputData({
        'title' : board.title,
        'content' : board.content
      });
    }
  }, [board]);

  console.log(inputData)

  //제목과 내용을 입력할 때마다 실행하는 함수
  const handleInputData= (e) => {
    setInputData({
      ...inputData,
      [e.target.name] : e.target.value
    });
  }

  //마운트했을때 기본 자료
  useEffect(() => {
    axios.get(`/api/boards/${boardNum}`)
    .then(res => {
      //console.log(res.data);
      setBoard(res.data);
    })
    .catch(error => console.log(error))
  }, []);

  //클릭했을때 수정하는 함수
  const goSet = () => {
    const result = confirm('수정하시겠습니까?')

    if(result){
      axios.put(`/api/boards/${boardNum}`, inputData)
      .then(res => {
        setBoard(res.data);
        alert('수정 완료');
        nav(`/detail/${boardNum}`)
      })
      .catch(error => console.log(error))
    }
  }

  return (
    <div className={styles.update_container}>
      <h1>게시글 수정 페이지</h1>
      <table>
        <tbody>
          <tr>
            <td>작성일</td>
            <td>{board.createDate}</td>
            <td>작성자</td>
            <td>{board.writer}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td colSpan={3}>
              <input type="text" 
                name='title' value={inputData.title}
                onChange={e=>handleInputData(e)}/>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>
              <textarea cols={50} rows={5} 
                name='content' value={inputData.content}
                onChange={e=>handleInputData(e)}></textarea>
            </td>
          </tr>
        </tbody>
      </table>

      <button type="button" onClick={e => nav(-1)}>뒤로가기</button>
      <button type="button" onClick={e => {
          goSet();  
        }}>수정</button>
    </div>
  )
}

export default UpdateForm