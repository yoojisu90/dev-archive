import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './BookList.css'

const BookList = (props) => {
  
  return (
    <div>
      <h3>도 서 목 록</h3>
      <table className='list-table'>
        <thead className='head'>
          <tr>
            <td>No</td>
            <td>도서번호</td>
            <td>도서명</td>
            <td>저자</td>
            <td>도서가격</td>
          </tr>
        </thead>
        <tbody className='body'>
        {
          props.bookList.map((e,i)=>{
            return(
              <tr key={i} onClick={()=>{
                props.setBookDetail(e);
                props.setIsShow(true);
              }}>
                <td>{props.bookList.length - i}</td>
                <td>{e.bookNum}</td>
                <td>{e.bookName}</td>
                <td>{e.writer}</td>
                <td>{e.price}원</td>
              </tr>
            )
          })
        }
        </tbody>
      </table>
    </div>
  )
}

export default BookList