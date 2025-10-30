import React from 'react'
import styles from './Select.module.css'

const Select = ({size='120px', children, ...props}) => {
  return (
    <div>
      <select className={styles.select} style={{width:size}} {...props}>
        {children}
      </select>
    </div>
  )
}

export default Select