import axios from 'axios';
import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Board from './Board'
import BoardDetail from './BoardDetail';

function App() {
  //게시글 목록을 저장할 state 변수
  const [boardList, setBoardList] = useState([]);

  //선택한 게시글 정보를 저장할 state 변수
  const [selectedBoard, setSelectedBoard] = useState({});

  //BoardDetail 컴포넌트가 보일지말지 결정할 state 변수
  const [isShow, setIsShow] = useState(false);

  useEffect(() => {
    axios.get('/api/boards')
    .then((res) => {
      console.log(res.data);
      setBoardList(res.data);
    })
    .catch((error) => {
      console.log(error);
    });
  },[]);


  return(
    <>
      <Board
        boardList={boardList}
        setSelectedBoard={setSelectedBoard}
        setIsShow= {setIsShow}
      />

      {
        isShow ? 
        <BoardDetail
        selectedBoard={selectedBoard}
         /> 
        :
        null
      }
      
    </>
  )
}

export default App
