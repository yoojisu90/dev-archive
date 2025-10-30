import React from 'react'
import './ToDoList.css'

const ToDoList = () => {
  const data = [
    {
      id: 1,
      txt: "리액트공부하기",
    },
    {
      id: 2,
      txt: "이력서작성하기",
    },
    {
      id: 3,
      txt: "주말엔휴식",
    },
  ]

  return (
    <div className='container'>
      <h1>To Do List</h1>
      <div>
        <input type="text" />
        <button type="button">등록</button>
      </div>
      <div>
      {
        data.map((data,i)=>{
          return(
            <div key={i} className='list-div'>
              <p>{data.txt}</p>
              <img src="edit.png" alt="" />
              <img src="delete.png" alt="" />
            </div> 
          )
        })
      }
      </div>
    </div>
  )
}

export default ToDoList