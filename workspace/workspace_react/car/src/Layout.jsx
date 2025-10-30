import React from 'react'
import Header from './Header'
import { Outlet } from 'react-router-dom'
import styles from './Layout.module.css'

const Layout = () => {
  return (
    <div className={styles.container}>
      <div>
        <Header />
      </div>
      <div>
        <Outlet />
      </div>
    </div>
  )
}

export default Layout