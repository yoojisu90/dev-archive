import axios from 'axios';
import React, { useEffect, useState } from 'react'

const StuList = () => {
  //조회한 학급 목록 데이터를 저장할 state 변수
  const [classList, setClassList] = useState([]);

  //조회한 학생 목록 데이터를 저장할 state 변수
  const [stuList, setStuList] = useState([]);

  //학급목록과 학생목록을 동시에 조회
  useEffect(() => {
    axios.all(
      [axios.get('/api/class'), axios.get('/api/students')]
    )
    .then(axios.spread((res1, res2) => {
      setClassList(res1.data);
      setStuList(res2.data);
    }))
    .catch(e => console.log(e));
  }, []);

  //셀렉트 박스의 값이 바뀌면 학생 목록을 다시 조회하는 함수
  //매개변수는 선택한 classNum이다.
  const getStuList = (classNum) => {
    axios.get(`/api/students/${classNum}`)
    .then(res => setStuList(res.data))
    .catch(e => console.log(e))  
  }

  return (
    <div>
      <div>
        <select name='className' value={stuList.classNum} onChange={e => getStuList(e.target.value)}>
          <option value='0'>전체</option>
          {
            classList.map((e, i) => {
              return(
                <option key={i} value={e.classNum}>{e.className}</option>
              )
            })
          }
        </select>
      </div>
      <div>
        <table border={1}>
          <thead>
            <tr>
              <td>No</td>
              <td>학급명</td>
              <td>학생명</td>
              <td>나이</td>
            </tr>
          </thead>
          <tbody>
          {
            stuList.map((stu, i)=>{
              return(
                <tr key={i}>
                  <td>{i + 1}</td>
                  <td>{stu.classDTO.className}</td>
                  <td>{stu.stuName}</td>
                  <td>{stu.stuAge}</td>
                </tr>
              )
            })
          
          }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default StuList