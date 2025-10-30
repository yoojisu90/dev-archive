import React, { useState } from 'react'
import './BookDetail.css'
const BookDetail = (props) => {
  
  return (
    <div>
      <h3>도서 상세 정보</h3>
      <table className='info-table'>
        <tbody className='info'>
          <tr>
            <td>도서번호</td>
            <td>{props.bookDetail.bookNum}</td>
            <td>도서명</td>
            <td>{props.bookDetail.bookName}</td>
          </tr>
          <tr>
            <td>저자</td>
            <td>{props.bookDetail.writer}</td>
            <td>가격</td>
            <td>{props.bookDetail.price}원</td>
          </tr>
          <tr>
            <td>도서소개</td>
            <td colSpan={3}>{props.bookDetail.bookInfo}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BookDetail