function passwordcheck(){
       
    const passwordValue = document.getElementById('password').value;
    const psCheckResult = document.getElementById('psCheckResult');
    const psLength = passwordValue.length;
    if(psLength == 0){
        psCheckResult.innerHTML = '필수항목입니다';
        psCheckResult.style.color = 'red';
    }else if(psLength<8 || psLength>20){
        psCheckResult.innerHTML = '8~20자 이내로 작성해주세요';
    }else if(psLength>=8 || psLength<=20){
        psCheckResult.innerHTML = '좋습니다!';
        psCheckResult.style.color = 'green'
    }
}
function pscheck(){
      const psCheckResults = document.getElementById('psCheckResults');
     if(psCheckResult==psCheckResults){
      psCheckResults.innerHTML = '일치합니다.!';
      psCheckResults.style.color = 'green'
     }else{
      psCheckResults.innerHTML = '일치하지 않습니다.';
      psCheckResults.style.color = 'red';
     }
  }