import React from 'react'
import styles from './Header.module.css'
import { Outlet, useNavigate } from 'react-router-dom'

const Header = () => {
  const nav = useNavigate();

  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <colgroup>
          <col width='25%'/>
          <col width='25%'/>
          <col width='25%'/>
          <col width='25%'/>
        </colgroup>
        <thead>
          <tr>
            <td onClick={e => nav('/')}>홈</td>
            <td onClick={e => nav('/cars')}>차량관리</td>
            <td onClick={e => nav('/sales')}>판매정보등록</td>
            <td onClick={e => nav('/sales-list')}>판매목록조회</td>
          </tr>
        </thead>
      </table>
    </div>
  )
}

export default Header