import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import BoardList from './BoardList'
import RegForm from './RegForm'
import BoardDetail from './BoardDetail'
import { Route, Routes } from 'react-router-dom'
import UpdateForm from './UpdateForm'

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<BoardList />}/>
        <Route path='/insert' element={<RegForm />}/>
        <Route path='/detail/:boardNum' element={<BoardDetail />}/>
        <Route path='/update/:boardNum' element={<UpdateForm />} />
        <Route path='*' element={ <div>없는 페이지입니다</div> } />
      </Routes>
    </>
  )
}

export default App
