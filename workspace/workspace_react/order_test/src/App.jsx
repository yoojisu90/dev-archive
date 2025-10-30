import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import OrderList from './OrderList'
import axios from 'axios'
import OrderDetail from './OrderDetail'

function App() {
  const [orderList, setOrderlist] = useState([]);

  const [detailOrder, setDetailOrder] = useState({});

  const [isShow, setIsShow] = useState(false);
  useEffect(() => {
    axios.get('/api/orders')
    .then((res) => {
      console.log(res.data);
      setOrderlist(res.data);
    })
    .catch((error) => {
      console.log(error);
    }); 
  }, []);
  
  return (
    <>
      <OrderList
      orderList={orderList} 
      setDetailOrder={setDetailOrder}
      setIsShow={setIsShow}
      />

      {
        isShow ?  
        <OrderDetail detailOrder={detailOrder}/>
        :
        null
      }
    </>
  )
}

export default App
