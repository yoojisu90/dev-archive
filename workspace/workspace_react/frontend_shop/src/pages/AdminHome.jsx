import React, { useEffect, useState } from 'react'
import styles from './AdminHome.module.css'
import axios from 'axios';

const AdminHome = () => {
  const [recentDate, setRecentDate] = useState([]);

  const [totalPrice, setTotalPrice] = useState([]);

  console.log(recentDate);
  console.log(totalPrice);

  useEffect(() => {
    axios.get('/api/buys/recent-date')
    .then(res => setRecentDate(res.data))
    .catch(e => console.log(e))

    axios.get('/api/buys/total-price')
    .then(res => setTotalPrice(res.data))
    .catch(e => console.log(e))
  }, []);

  return (
    <div className={styles.container}>
      <div className={styles.first_row}>
        <div>오늘의매출</div>
        <div>전체매출</div>
        <div>오늘의방문자수</div>
        <div>이번달방문자수</div>
      </div>
      <div className={styles.second_row}>
        <div>최근 10일간 매출(꺽은선그래프)</div>
      </div>
    </div>
  )
}

export default AdminHome