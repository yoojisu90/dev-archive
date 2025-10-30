import React, { useEffect, useState } from 'react'
import BookList from './BookList'
import BookDetail from './BookDetail'
import axios from 'axios';
import './BookInfo.css'

const BookInfo = (props) => {
  const [bookList, setBookList] = useState([]);
  const [bookDetail, setBookDetail] = useState({});
  const [isShow, setIsShow] = useState(false);
   
  useEffect(()=>{
    axios.get('/api/books')
    .then((res)=>{
      console.log(res.data)
      setBookList(res.data);
    })
    .catch(error=>console.log(error));
  }, []);

  return (
    <div className='container'>
      <BookList 
        bookList={bookList}
        setBookDetail={setBookDetail}
        setIsShow={setIsShow} 
      />

      {
        isShow ?
        <BookDetail bookDetail={bookDetail}/>
        :
        null
      }
    </div>
  )
}

export default BookInfo