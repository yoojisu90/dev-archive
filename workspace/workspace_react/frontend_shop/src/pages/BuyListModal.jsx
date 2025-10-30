import React, { useEffect, useState } from 'react'
import Modal from '../common/Modal'
import styles from './BuyListModal.module.css'
import axios from 'axios';

const BuyListModal = ({detailList, isOpen, onClose}) => {

  return (
    <Modal
      size='700px'
      title='구매 상세 내역'
      isOpen={isOpen}
      onClose={onClose}
    >
      <div className={styles.container}>
        <table className={styles.table}>
          <colgroup>
            <col width='10%'/>
            <col width='*'/>
            <col width='15%'/>
            <col width='10%'/>
            <col width='20%'/>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>상품정보</td>
              <td>가격</td>
              <td>수량</td>
              <td>총가격</td>
            </tr>
          </thead>
          <tbody>
          {
            detailList.map((list, i) => {
              return(
                <tr key={i}>
                  <td>{detailList.length - i}</td>
                  <td>
                    <div className={styles.img_div}>
                      <img src={`http://localhost:8080/upload/${list.bookDTO.imgList[0].attachedImgName}`} />
                     <p>{list.bookDTO.title}</p>                    
                    </div>
                  </td>
                  <td>{list.bookDTO.price.toLocaleString()}원</td>
                  <td>{list.buyCnt}</td>
                  <td>{list.totalPrice.toLocaleString()}원</td>
                </tr>
              )
            })
          }
          </tbody>
        </table>
      </div>
    </Modal>
    
  )
}

export default BuyListModal