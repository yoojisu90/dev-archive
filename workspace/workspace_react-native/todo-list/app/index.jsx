import axios from 'axios'
import { useEffect, useState } from 'react'
import { FlatList, Keyboard, StyleSheet, Text, TextInput, TouchableWithoutFeedback, View } from 'react-native'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'
import { SERVER_URL } from '@/constants/appConst'

const HomeScreen = () => {
  //조회한 할 일 목록 데이터를 저장할 state 변수
  const [todoList, setTodoList] = useState([]);

  //입력한 제목 데이터를 저장할 state 변수
  const [todoTitle, setTodoTitle] = useState('');

  //목록 조회 재실행을 위한 의존성 배열 데이터
  const [reload, setReload] = useState(0);

  //마운트 되면 목록 조회
  useEffect(() => {
    axios.get(`${SERVER_URL}/todo`)
    .then(res => {
      console.log(res.data)
      setTodoList(res.data)
    })
    .catch(e => console.log(e))
  }, [reload]);

  //할 일 등록
  const addTodo = () => {
    axios.post(`${SERVER_URL}/todo`, {'todoTitle' : todoTitle})
    .then(res => {
      alert('등록성공');
      
      //목록 재조회, 입력한 글자 초기화
      setTodoTitle('');
      changeReload();
    })
    .catch(e => {
      //오류 상태코드
      const errorCode = e.status;
      
      if(errorCode === 400 || errorCode === 500){
        alert(`오류 코드 : ${errorCode}\n오류 메세지 : ${e.response.data}`);
      }
      else{
        console.log(e)
      }
    })
  }

  //reload값 변경 함수
  const changeReload = () => {
    setReload(reload + 1);
  }

  return (
    //빈 화면 터치 시 키보드 숨김 기능을 구현할 때 사용
    //onPress props에 키보드 숨김 기능을 구현
    <TouchableWithoutFeedback onPress={Keyboard.dismiss}>
      <SafeAreaView style={styles.container}>
        
        <View>
          <Text style={styles.title}>To Do List</Text>
        </View>

        <View style={styles.input_view}>
          <TextInput 
            style={styles.input}
            placeholder='+ Add a Task'
            value={todoTitle}
            onChangeText={text => setTodoTitle(text)}
            //폰 키보드에서 확인, ok, confirm 등의 키 터치시 발생
            onSubmitEditing={() => addTodo()}
            //인풋 태그가 focus를 잃었을 때 실행
            onBlur={()=>{setTodoTitle('')}}
          />
        </View>

        <View style={styles.list_view}>
          <FlatList 
            //전체 데이터
            data={todoList}
            //데이터로 그림 그리치, 매개변수 : 데이터 하나하나
            renderItem={({item}) => 
              <Task 
                data={item} 
                changeReload={changeReload}
              />
            }
            //map 의 ket={i} 내용과 동일
            keyExtractor={item => item.todoNum}
          />
        </View>

      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  container : {
    flex : 1, //최상위 태그의 높이를 폰 화면에 꽉 차게 변경
    padding : 20
    //paddingHorizontal:10, 좌우 패딩
    //paddingVertical : 10  상하 패딩
  },
  input :{
    borderWidth : 1,
    borderColor : '#cccccc',
    borderStyle : 'solid'
  },
  title :{
    fontSize : 36,
    fontWeight : 'bold'
  },
  input_view : {
    marginVertical : 20
  },
  list_view :{
    backgroundColor : '#cccccc',
    padding : 10,
    gap : 10
  }
})