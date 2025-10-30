import React, { useEffect, useState } from 'react'
import Button from '../common/Button'
import Input from '../common/Input'
import styles from './BuyList.module.css'
import axios from 'axios'
import dayjs from 'dayjs'
import BuyListModal from './BuyListModal'
import Modal from '../common/Modal'

const BuyList = () => {
  //입력한 검색 조건 데이터를 저장할 state변수
  const [searchData, setSearchData] = useState({
    'orderNum' : '',
    'memId' : '',
    'fromDate' : '',
    'toDate' : ''
  });

  //검색 데이터를 입력할 때 마다 실행하는 함수
  const handleSearchData = (e) => {
    setSearchData({
      ...searchData,
      [e.target.name] : e.target.value
    })
  }

  //구매 상세 내역 모달 보이기 여부를 위한 state변수
  const [isOpen, setIsOpen] = useState(false);

  //조회한 구매 상세 정보를 저장할 state변수
  const [detailList, setDetailList] = useState([]);

  //구매 이력 변경을 위한 state변수
  const [buyList, setBuyList] = useState([]);

  //마운트 했을때 구매 이력 조회
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e))
  }, []);

  //구매 상세 내역조회 
  const getDetail = (orderNum) =>{
    axios.get(`/api/buys/buy-list-admin/${orderNum}`)
    .then(res => {
      console.log(res.data)
      setDetailList(res.data)
    })
    .catch(e => console.log(e))
  }

  //검색 버튼 클릭 시 실행 함수
  const doSearch = () => {
    axios.get('/api/buys/buy-list-admin', {params : searchData})
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <div className={styles.head_div}>
        <h2>구매 이력 조회</h2>
        <div className={styles.search}>
          <div>
            <p>구매번호</p>
            <Input 
              size='150px'
              name='orderNum'
              value={searchData.orderNum}
              onChange={e=>handleSearchData(e)}
            />
          </div>
          <div>
            <p>구매자ID</p>
            <Input 
              size='150px'
              name='memId'
              value={searchData.memId}
              onChange={e=>handleSearchData(e)}
            />
          </div>
          <div>
            <p>구매일시</p>
            <Input
              size='150px' 
              type='date'
              name='fromDate'
              value={searchData.fromDate}
              onChange={e=>handleSearchData(e)}
            />
            <span>-</span>
            <Input 
              size='150px' 
              type='date'
              name='toDate'
              value={searchData.toDate}
              onChange={e=>handleSearchData(e)}
            />
          </div>
          <div>
            <Button 
              title='검색'
              size='100px'
              onClick={e => doSearch()}
            />
          </div>
        </div>
      </div>
      <div>
        <h3>총 {buyList.length}건이 검색되었습니다</h3>
        <div>
          <table className={styles.table}>
            <colgroup>
              <col width='5%'/>
              <col width='10%'/>
              <col width='*'/>
              <col width='15%'/>
              <col width='15%'/>
              <col width='20%'/>
            </colgroup>
            <thead>
              <tr>
                <td>No</td>
                <td>주문번호</td>
                <td>구매상품</td>
                <td>구매자ID</td>
                <td>결제금액</td>
                <td>구매일시</td>
              </tr>
            </thead>
            <tbody>
            {
              buyList.map((buyInfo, i) => {
                return(
                  <tr key={i}>
                    <td>{buyList.length - i}</td>
                    <td>{buyInfo.orderNum}</td>
                    <td><span
                      className={styles.modal_span}
                      onClick={e => {
                        //클릭한 행의 상세 내역 조회
                        getDetail(buyInfo.orderNum)
                        //모달을 보이게 변경
                        setIsOpen(true)
                      }} 
                    >{buyInfo.title}</span></td>
                    
                    <td>{buyInfo.memId}</td>
                    <td>
                      {buyInfo.price.toLocaleString()}원
                    </td>
                    <td>
                      {dayjs(buyInfo.buyDate).format("YYYY-MM-DD HH:mm")}
                    </td>
                  </tr>
                )
              })
            }
            </tbody>
          </table>
        </div>
            
        {/* 구매 상세 내용 모달 */}
        <BuyListModal 
          isOpen = {isOpen}
          detailList = {detailList}
          onClose = {() => {setIsOpen(false)}}
        />

      </div>
    </div>
  )
}

export default BuyList