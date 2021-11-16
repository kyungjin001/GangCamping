const btn1 = document.getElementById('id2');
console.log("btn1값:",btn1)
// id2가 적용된 요소(body에 작성된 태그)를 가져옴.
const btn2 = document.getElementById('id3');
console.log("btn2값:",btn2)
// id3가 적용된 요소를 가져옴.
// function() -> 익명함수임

// addEventListener를 이용하여
// id2가 적용된 버튼을 클릭했을 때 익명함수를 호출
btn1.addEventListener('click',function(){
    console.log("id2 버튼 클릭함")
    const result = confirm("컨펌함수입니다.")
    // 확인 : true , 취소:false
    if(result){
        console.log("확인을 누르셨네요")
   }else{    
    console.log("취소를 누르셨네요")
   }
});

// addEventListener를 이용하여 
// id3가 적용된 버튼을 클릭했을 때
// promtFunction 이라는 함수를 호출하도록 함. -->

btn2.addEventListener('click',promtFunction)




function promtFunction(){
    console.log('promtFunction 함수 호출됨')  
    const result = prompt('프롬프트함수입니다.')
    console.log(result);
}
function alertFunction(){
    console.log('alertFunction 함수 호출됨')   
    alert('안녕하세요')    
}