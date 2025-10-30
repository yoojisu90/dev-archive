import { useState } from 'react';
import { Pressable, StyleSheet, Text, TextInput, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

const HomeScreen = () => {
  //input 태그에 입력한 글자를 저장할 state 변수
  const [data, setData] = useState('');

  //이름, 나이, 주소 값을 저장할 state 변수
  const [memberData, setMemberData] = useState({
    name : '',
    age : '',
    addr : ''
  });
  
  const handleMemberData = (value, key) => 
    setMemberData({
      ...memberData,
      [key] : value
    })

  return (
    <SafeAreaView>
      <Text style={styles.my_text}>index</Text>

      <Pressable onPress={(e) => {alert(1)}}>
        <Text style={styles.my_btn}>버튼</Text>
      </Pressable>
        
      <View style={styles.div}>
        <TextInput 
          style={styles.input}
          // onChangeText 이벤트의 매개변수는 입력한 글자를 의미
          onChangeText={(str) => {
            setData(str)
          }}
        />
  
        <Pressable onPress={(e) => {alert(data)}} style={styles.pre}>
          <Text style={styles.btn}>클 릭</Text>
        </Pressable>
      </View>

      <View>
        <Text>이름</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'name')}
        />
        <Text>나이</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'age')}
        />
        <Text>주소</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'addr')}
        />

        <Pressable 
          onPress={e => alert(
            `이름 : ${memberData.name}\n
            나이 : ${memberData.age}\n
            주소 : ${memberData.addr}`
            )}
        >
          <Text>버 튼</Text>
        </Pressable>
      </View>


    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  my_text : {
    backgroundColor : 'red',
    padding : 10
  },
  my_btn: {
    backgroundColor : 'blue',
    color : 'white',
    borderWidth : 1,
    borderColor : 'blue',
    borderStyle : 'solid',
    width : '20%',
    textAlign : 'center'
  },
  input : {
    borderBottomWidth : 1,
    borderBottomColor : '#cccccc',
    borderStyle : 'solid',
    width : '80%'
  },
  pre : {
    borderWidth : 3,
    borderColor : 'yellow',
    borderStyle : 'solid',
    width : '20%',
  },
  btn : {
    borderWidth : 3,
    borderColor : 'blue',
    borderStyle : 'solid',
    backgroundColor : 'blue',
    color : 'white',
    textAlign : 'center'
  },
  div : {
    flexDirection : 'row'
  }

})