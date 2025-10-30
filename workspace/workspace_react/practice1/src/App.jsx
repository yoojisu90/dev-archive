import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './Header'
import Content from './Content'
import Footer from './Footer'

function App() {

  return (
    <div className='container'>
      <Header></Header>
      <Content></Content>
      <Footer></Footer>
    </div>
  )
}

export default App
