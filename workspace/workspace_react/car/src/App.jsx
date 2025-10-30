import './App.css'
import { Route, Routes } from 'react-router-dom'
import Car from './Car'
import Sales from './Sales'
import Home from './Home'
import Layout from './Layout'
import SalesList from './SalesList'

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='' element={<Home />}/>
          <Route path='cars' element={<Car />}/>
          <Route path='sales' element={<Sales />}/>
          <Route path='sales-list' element={<SalesList />}/>
        </Route>
      </Routes>
    </>
  )
}

export default App
