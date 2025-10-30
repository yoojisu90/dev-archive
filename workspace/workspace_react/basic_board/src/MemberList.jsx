import React, { useEffect, useState } from 'react'
import axios from 'axios';

const MemberList = () => {
  //조회된 회원목록을 저장할 state 변수
  const [memberList, setMemberList] = useState([]);

  useEffect(() => {
    //Spring에서 회원 목록 데이터 가져오기
    axios.get('/api/members')
    .then(res => {
      console.log(res.data);
      setMemberList(res.data);
    })  
    .catch(error => console.log(error))
  }, []);
  

  return (
    <div>
      <h3>회원목록</h3>
      <table>
        <thead>
          <tr>
            <td>아이디</td>
            <td>이름</td>
            <td>나이</td>
          </tr>
        </thead>
        <tbody>
        {
          memberList.map((member, i) => {
            return(
              <tr key={i}>
                <td>{member.memId}</td>
                <td>{member.memName}</td>
                <td>{member.memAge}</td>
              </tr>
            )
          })
        }  
        </tbody>
      </table>
    </div>
  )
}

export default MemberList