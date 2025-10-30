import React from 'react'
import './OrderDetail.css'
const OrderDetail = (props) => {
  return (
    <div className='container'>
      <h2>주문 상제 정보</h2>
      <table className='detail-table'>
        <tbody>
          <tr>
            <td>상품번호</td>
            <td>{props.detailOrder.productNum}</td>
            <td>상품명</td>
            <td>{props.detailOrder.productName}</td>
          </tr>
          <tr>
            <td>가격</td>
            <td>{props.detailOrder.price}</td>
            <td>수량</td>
            <td>{props.detailOrder.cnt}</td>
          </tr>
          <tr>
            <td>주문자ID</td>
            <td>{props.detailOrder.buyer}</td>
            <td>구매금액</td>
            <td>{props.detailOrder.price * props.detailOrder.cnt}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default OrderDetail