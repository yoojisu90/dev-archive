import React from 'react'
import styles from './Button.module.css'

const Button = ({title='버튼' , size='80px', color='blue', onClick, ...props}) => {
  return (
    
    <button 
      type="button"
      className={
        `${styles.btn} ${styles[color]} ${props.disabled && styles.disabled}`
      }
      style={{width:size}}
      onClick={onClick}
      {...props}
    >{title}</button>
  
  )
}

export default Button