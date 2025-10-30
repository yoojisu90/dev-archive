import React from 'react'
import './OrderList.css'

const OrderInfo = (props) => {
  return (
    <div className='container'>
      <table className='list-table'>
        <thead className='head'>
          <tr>
            <td>No</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>수량</td>
            <td>총구매가격</td>
          </tr>
        </thead>
        <tbody className='body'>
        {
          props.orderList.map((e,i) => {
            return(
              <tr key={i} onClick={() => {
                props.setDetailOrder(e);
                props.setIsShow(true);
              }}>
                <td>{props.orderList.length - i}</td>
                <td>{e.productName}</td>
                <td>{e.price}</td>
                <td>{e.cnt}</td>
                <td>{e.price * e.cnt}</td>
              </tr>
            )
          })
        }
        </tbody>
      </table>
    </div>
  )
}

export default OrderInfo