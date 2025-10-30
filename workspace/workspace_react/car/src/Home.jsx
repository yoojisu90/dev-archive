import React from 'react'
import { Outlet } from 'react-router-dom'
import styles from './Home.module.css'

const Home = () => {
  return (
    <div className={styles.container}>
      <h1>차량 판매 정보 시스템</h1>
    </div>
  )
}

export default Home