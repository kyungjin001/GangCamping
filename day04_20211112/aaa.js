const btn1 = document.getElementById('id2'); 


btn1.addEventListener('click', function(){
    console.log("id2 버튼 클릭함")
});

const btn2 = document.getElementById('id3'); 

btn2.addEventListener('click',promtFunction);



function alertFunction(){
    console.log('alertFunction 함수 호출됨')       
}
function promtFunction(){
    console.log('promtFunction 함수 호출됨')       
}


