import React from 'react'
import './Header.css'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <div className='header-container'>
      <div className='profile'>
        <span>
          <Link to={'/join'}>Join</Link>
        </span>
        <span>
          <Link to={'/login'}>Login</Link>
        </span>
      </div>
      <div className='title'>
        <Link to={''}>P R O J E C T</Link>
      </div>
    </div>
  )
}

export default Header