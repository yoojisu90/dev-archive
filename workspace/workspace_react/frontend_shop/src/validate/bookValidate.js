export const handleErrorMsg = (e) => {
  //도서명,출판사 유효성 검사 20자이하 영문,한글,+숫자만가능
  const titleRegex = /^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{1,20}$/;

  //숫자 유효성 검사 양수인 숫자만 가능
  const priceRegex = /^(?:[1-9]\d{0,2}(?:,\d{3})*|0)$/;

  let errorStr = '';

  switch(e.target.name){
    case 'cateNum' :
      if(!e.target.value){
        errorStr = '카테고리를 선택하세요'
      }
      else{
        errorStr = '';
      }
      break; 

    case 'title' :
      if(!e.target.value){
        errorStr = '제목은 필수입력입니다'
      }
      else if(e.target.value.lengtn > 20){
        errorStr = '제목은 20자 이하여야 합니다'
      }
      else if(!titleRegex.test(e.target.value)){
        errorStr = '제목은 영문,한글,숫자만 가능합니다'
      }
      else{
        errorStr = '';
      }
      break;

    case 'publisher' :
      if(!e.target.value){
        errorStr = '출판사는 필수입력입니다'
      }
      else if(e.target.value.lengtn > 20){
        errorStr = '출판사은 20자 이하여야 합니다'
      }
      else if(!titleRegex.test(e.target.value)){
        errorStr = '출판사는 영문,한글,숫자만 가능합니다'
      }
      else{
        errorStr = '';
      }
      break;
    
    case 'price' : 
      if(!e.target.value){
        errorStr = '가격은 필수입력입니다'
      }
      else if(!priceRegex.test(parseInt(e.target.value).toLocaleString())){
        errorStr = '가격은 양수만 입력 가능합니다'
      }
      else{
        errorStr = '';
      }
  }

  return errorStr;

}