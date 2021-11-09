# 제목입니다.
## 제목입니다.
### 제목입니다.
#### 제목입니다.
- 텍스트 내용입니다.
    - 안녕하세요
1. 숫자내용
1. 숫자내용
```
int a = 10;
```
1. 안녕하세요






# 수업내용 정리
## front 1일차(20211109)
### 인라인 요소(inline element), 블록 요소(block element)
1. 인라인 요소
    - 태그 내용을 표현하고 줄이 바뀌지 않음.
    - 보통 텍스트 내용만큼만 영역을 차지하게 됨.
    - 가로, 세로 크기를 따로 지정할 수 없음.
        - 가로,세로 크기를 따로 지정하고 싶으면 css로 블록 요소 지정해야함.
    - 대표적인 인라인 태그
        - span, a 등
2. 블록 요소
    - 태그 내용을 표현하고 줄이 바뀜.
    - 텍스트 내용과는 상관없이 한줄을 모두 차지함.
    - 가로, 세로 크기를 지정할 수 있음.
    - 대표적인 블록 태그
        - div, h1~h6 등


 ### 주로 사용하게 될 태그들
 ```
- <style>, <script>, <h1>,<p>, <div>
- <form> , <input>, <button>, <select>
```

## UI/UX
- UI(User Interface) : 화면, GUI(Graphical User Interface). 얼마나 보기 좋냐
- UX(User exprience) : 사용자 경험, 얼마나 쓰기 좋냐

### 경로 지정시 사용하는 방법
- ./: 현재 파일이 있는 폴더를 가리킴.
- ../: 현재 폴더에서 한수준 위로 올라가는 폴더를 가리킴.

### form 태그
1. form 시작태그에 작성하는 속성
```
<form action= "주소값" method = "get or post">
```
    - action:form태그에 작성된 내용을 전송할 주소
        - 보통 백엔드에서 받는 주소를 사용함.
        - 백엔드에는 해당 주소를 처리해주는 컨트롤러 클래스의 메서드가 있음.
    - method: action에 작성한 주소로 데이터를 전송할 때 사용할 전송방식
        - 여기서 전송방식이라는 것은 http 프로토콜의 전송방식을 의미함.
        - http 전송방식(rest api )
            - get : read 역할(select)
                - 주소창에 전송하는 데이터가 모두 노출됨.
                - 검색어 또는 데이터가 노출되어도 문제 없는 상황에서 사용.
            - post : create 역할(insert)
                - 주소창에 전송하는 데이터가 노출되지 않음.
                - 회원가입, 로그인 등 노출되지 않아야 하는 상황에서 사용.
            - put : update 역할(update)
            - delete : delete 역할(delete)
        - form태그의 method에는 get/post만 사용가능
        - http(hyper text transfer protocol): 쉽게 말해서 인터넷 상에서 정보를 주고받는 프로토콜
            - http는 대부분 요청(request, req) / 응답(response, res)이 있다.
                - fronted(client) -> backend(server): 요청
                    - server: java, db
                    - client : html, css, javascript
                - backend -> fronted : 응답
            - 우리가 인터넷을 한다는 것은 서버에 요청을 하는 것이고 그에 대한 결과를 화면으로          보는것이 응답.
            - 따라서 인터넷을 할 때 주소창에 http:// 가 붙는 것이라고 보면 된다.
                - 요즘 https는 secure(보안)이 추가됐다고 보면됨.
            - 프로토콜(protocol): 특종 통신 방식에서 규정하는 규칙을 의미
            - ftp, tcp, ip 등에 붙는 p는 모두 프로토콜임
2. input 태그

- type 속성
    - text:텍스트 입력칸이 만들어짐.
    - submit: form 태그에 작성한 내용을 action 속성에 작성한 주소로 보낼 수 있음.


- 네이버 검색창을 분석해보자
    - 네이버 검색 요청 주소: https://search.naver.com/search.naver
    - 검색어를 담는 파라미터 이름:query
    - 검색 요청 방식:get