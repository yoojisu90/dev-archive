import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import Input from '../common/Input';
import Button from '../common/Button';
import styles from './CartList.module.css'
import dayjs from 'dayjs';

const CartList = () => {
  //장바구니 목록 데이터를 조회하는 useEffect를 재실행하기 위한 변수
  const [reload, setReload] = useState(0);

  const nav = useNavigate();

  //조회한 카트 리스트를 변경할 state변수
  const [cartList, setCartList] = useState([]);
  console.log(cartList)
  
  //선택한 체크박스 값을 저장할 state 변수
  //모든 체크박스가 선택된 채로 화면이 나오려면 조회한 모든 cartNum이 초기값으로 세팅 되어야 함
  const [checkData, setCheckData] = useState([]);
  
  //전체 체크박스의 체크여부를 저장할 state 변수
  const [isChecked, setIsChecked] = useState(true);

  //최종 구매 가격을 저장할 state 변수
  const [finalPrice, setFinalPrice] = useState(0);

  //조회한 장바구니 목록의 모든 cartNum을 저장할 배열
  //arr 변수는 화면에 보여줄 데이터가 아니기 때문에 state 변수로 줄 필요가 없다.
  //하지만, state 변수가 아니면 리렌더링 됐을 때 arr이 초기화 되버리는 문제가 발생
  //우리가 원하는건 
  // 1. 변수의 값이 초기화되지 않아야 한다
  // 2. 값이 변해도 리렌더링 할 필요는 없다
  // -> 이 두 조건을 만족하기 위해서는 useRef로 변수를 선언한다.
  // useRef를 사용하면 초기값이 current라는 키의 value로 저장된다.
  const arr = useRef([]); // arr = {current : []}

  //조회한 장바구니 목록 전체 가격의 합을 저장할 변수
  let price = useRef(0);

  //console.log(checkData);
    
  
  //마운트 시 장바구니 목록 조회
  useEffect(() => {
  //로그인한 회원 ID
    const loginInfo = sessionStorage.getItem('loginInfo')
    //장바구니 페이지를 들어왔는데 만약 로그인 되어있지 않으면
    //강제로 상품 목록 페이지로 이동시키기
    if(loginInfo === null){
      alert('접근 권한이 없습니다')
      nav('/');
      return;
    }
    
    //JSON -> 객체변환
    const memId = JSON.parse(loginInfo).memId;

    axios.get(`/api/carts/${memId}`)
    .then(res => {
      setCartList(res.data)

      //체크박스 초기값 세팅
      for(const e of res.data){
        arr.current.push(e.cartNum);
      }
      setCheckData(arr.current);
      
      //총 구매 가격 세팅
      //장바구니 목록을 조회할때마다 총 가격은 0으로 초기화 후 계산
      price.current=0;
      for(const e of res.data){
        price.current = price.current + e.totalPrice;
      }
      setFinalPrice(price.current);

    })
    .catch(e => console.log(e))
  }, [reload]);

  //체크박스 값 변경시 실행 함수
  const handleCheckbox = (e) => {
    //체크가 됐다면...
    //cartNum을 숫자로 변환해서 저장 -> parseInt(문자열)
    if(e.target.checked){
      setCheckData([...checkData, parseInt(e.target.value)]);
    }
    //체크가 해제 됐다면...
    else{
      const result = checkData.filter((cartNum) => {return cartNum != e.target.value});
      setCheckData(result);
    }
  }

  //제목 줄의 체크박스가 변할 때, 총 구매 가격을 변경하는 함수
  const handleFinalPriceAtTitle = (e) => {
    if(e.target.checked){
      setFinalPrice(price.current)
    }
    else{
      setFinalPrice(0);
    }
  }

  //내용 줄의 체크박스가 변할 때, 총 구매 가격을 변경하는 함수
  const handleFinalPrice = (price, e) => {
    //체크가 됐다면
    if(e.target.checked){
      setFinalPrice(finalPrice + price);
    }
    //체크가 해제됐다면
    else{
      setFinalPrice(finalPrice - price);
    }
  }

  //삭제 버튼 눌렀을때 실행 함수
  const deleteCart = (cartNum) => {
    const result = confirm('선택한 상품을 장바구니에서 비우겠습니까?');

    if(result){
      axios.delete(`/api/carts/${cartNum}`)
      .then(res => {
        alert('장바구니 상품을 삭제하였습니다')
        //reload값이 바뀌면서 useEffect 안의 장바구니 목록 조회가 재실행
        setReload(reload+1);
      })
      .catch(e => console.log(e))
    }
  }
  
  //수량 변경하는 함수
  const updateCart = (e, cartNum, bookNum) => {
    axios.put('/api/carts', {
      cartCnt : e.target.value,
      bookNum : bookNum,
      cartNum : cartNum
    })
    .then(res => setReload(reload +1))
    .catch(e => console.log(e))
  }

  

  //선택 구매
  const buyAll = () => {
    //sessionStorage에 저장된 로그인 정보
    const loginInfo = sessionStorage.getItem('loginInfo');
    //로그인 정보에서 memId만 추출
    const memId = JSON.parse(loginInfo).memId;

    axios.post('/api/buys/all', {
      memId : memId,
      cartNumList : checkData
    })
    .then(res => {
      alert('선택한 도서를 구매했습니다');
      //reload 값이 변경되면 장바구니 목록 조회 기능이 있는 
      //useEffect가 재실행된다.
      setReload(reload+1);
    })
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <table className={styles.cart_list_table}>
        <colgroup>
          <col width='3%'/>
          <col width='4%'/>
          <col width='*'/>
          <col width='10%'/>
          <col width='10%'/>
          <col width='10%'/>
          <col width='17%'/>
          <col width='7%'/>
        </colgroup>
        <thead>
          <tr>
            <td>
              <input 
                type="checkbox" 
                checked={isChecked}
                onChange={e => {
                  //전체 체크 박스가 체크 -> 모든 체크 박스 체크
                  //전체 체크 박스가 체크해제 -> 모든 체크 박스 체크 해제
                  e.target.checked ? setCheckData(arr.current) : setCheckData([]);
                  
                  //제목줄의 체크 박스 체크여부 결정
                  setIsChecked(!isChecked);

                  //제목줄의 체크 여부에 따라 총 구매 가격 변경
                  handleFinalPriceAtTitle(e);
                }}  
              />
            </td>
            <td>No</td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>총 가격</td>
            <td>등록일</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
        { 
          cartList.length === 0
          ?
          <tr>
            <td colSpan={8}>장바구니에 담은 도서가 없습니다</td>
          </tr>
          : 
          cartList.map((cart, i) => {

            return(
              <tr key={i}>
                <td><input 
                      type="checkbox"
                      checked={checkData.includes(cart.cartNum)}
                      value={cart.cartNum}
                      onChange={e=> {
                        //내용줄의 체크박스 체크여부 결정
                        handleCheckbox(e);
                        
                        //내용줄의 체크박스 체크여부에 따른 총 구매 가격 변경
                        handleFinalPrice(cart.totalPrice, e);

                      }}
                    /></td>
                <td>{cartList.length - i}</td>
                <td>
                  <div className={styles.item_info}>
                    <img key={i} className={styles.img}
                      src={`http://localhost:8080/upload/${cart.bookDTO.imgList[0].attachedImgName}`}/>
                    <p 
                      onClick={e => nav(`/book-detail/${cart.bookNum}`)} 
                      style={{cursor:'pointer'}}>{cart.bookDTO.title}</p>
                  </div>
                </td>
                <td>{cart.bookDTO.price.toLocaleString()}</td>
                <td>
                  <div className={styles.cnt_div}>
                    {/* 
                      인풋 태그의 value와 onChange는 한 쌍이다.
                      정상 작동을 위해서는 value에 사용하는 데이터와
                      onChange에서 컨트롤하는 데이터는 동일해야 한다!
                      만약 value와 onChange에서 사용하는 데이터가 다르면
                      input태그에 입력한 내용이 화면에 반영되지 않는다.

                      결론1. value와 onChange에 사용하는 데이터는 동일하게 사용하자
                      
                      하지만 value와 onChange의 코드를 작성하면 두 곳에서 사용하는 
                      데이터가 다른 경우도 존재한다.
                      이럴 경우에는,
                      결론2. value 대신 defaultValue를 사용한다.
                    */}
                    <Input
                      size='100%' 
                      type="number"
                      name="cartCnt" 
                      //value={cart.cartCnt}
                      defaultValue={cart.cartCnt}
                      onChange={e => {
                        updateCart(e, cart.cartNum, cart.bookNum)
                        e.target.value = e.target.value.replace(/[^0-9]/g, "");
                      }}
                     />
                  </div>
                </td>
                <td>{cart.totalPrice.toLocaleString()}</td>
                <td>{dayjs(cart.cartDate).format("YYYY-MM-DD HH:mm")}</td>
                <td>
                  <Button
                    size='100%' 
                    title='삭제'
                    color='gray'
                    onClick={e => deleteCart(cart.cartNum)}
                  />
                </td>
              </tr>
            )
          })
        }  
        </tbody>
      </table>
      <div className={styles.select_div}>
        <div>
          <p>구매가격 : </p>
          <p>{finalPrice.toLocaleString()}원</p>
        </div>
        <Button 
          title='선택 구매'
          onClick={e => buyAll()}
          
        />
      </div>
    </div>
  )
}

export default CartList