import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useLocalSearchParams } from 'expo-router'
import { SafeAreaView } from 'react-native-safe-area-context';

const DetailScreen = () => {
  //전달되는 데이터 받기
  const params = useLocalSearchParams();
  //const {id, age} = useLocalSearchParams(); 구조분해

  return (
    <SafeAreaView>
      <View>
        <Text>상세화면</Text>
        <Text>{params.id} / {params.age}</Text>
      </View>
    </SafeAreaView>
  )
}

export default DetailScreen

const styles = StyleSheet.create({})