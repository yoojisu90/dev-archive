import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import ItemList from './ItemList'
import RegForm from './RegForm'
import ItemDetail from './ItemDetail'
import UpdateForm from './UpdateForm'

function App() {

  return (
    <div className='container'>
      <Routes>
        <Route path='/' element={<ItemList />} />
        <Route path='/reg' element={<RegForm />} />
        <Route path='/detail/:itemNum' element={<ItemDetail />} />
        <Route path='/update/:itemNum' element={<UpdateForm />} />
      </Routes>
    </div>
  )
}

export default App
