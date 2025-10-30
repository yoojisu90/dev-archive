import axios from 'axios';
import React, { useEffect, useState } from 'react'
import styles from './SalesList.module.css'
import dayjs from 'dayjs';

const SalesList = () => {
  const [salesList, setSalesList] = useState([]);

  console.log(salesList)

  useEffect(() => {
    axios.get('/api/sales')
    .then(res => setSalesList(res.data))
    .catch(e => console.log(e))
  }, []);

  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <colgroup>
          <col width='5%'/>
          <col width='10%'/>
          <col width='20%'/>
          <col width='25%'/>
          <col width='10%'/>
          <col width='15%'/>
          <col width='15%'/>
        </colgroup>
        <thead>
          <tr>
            <td rowSpan={2}>No</td>
            <td colSpan={4}>구매자정보</td>
            <td colSpan={2}>차량정보</td>
          </tr>
          <tr>
            <td>구매자명</td>
            <td>연락처</td>
            <td>구매일</td>
            <td>색상</td>
            <td>모델명</td>
            <td>가격</td>
          </tr>
        </thead>
        <tbody>
        {
          salesList.map((e, i) => {
            return(
              <tr key={i}>
                <td>{salesList.length - i}</td>
                <td>{e.buyer}</td>
                <td>
                {
                e.phone && e.phone !== '' ? e.phone : '-'
                }
                </td>
                <td>{dayjs(e.saleDate).format("YYYY-MM-DD HH:mm")}</td>
                <td>{e.color}</td>
                <td>{e.carDTO.carName}</td>
                <td>{e.carDTO.price.toLocaleString()}원</td>
              </tr>
            )
          })
        }
        </tbody>
      </table>
    </div>
  )
}

export default SalesList