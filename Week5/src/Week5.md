객체.값 = 객체가 쳐다보는 메모리속의 값

String = 불변
객체 이름은 A 그대로 -> 메모리 주소만 재할당 -> 새로운 객체 생성
그러면 가비지가 생기는거 아닌가? -> ok

StringBuffer 는 번지수가 안바뀜
append, concat 같은 메소드 사용 가능
그러면 인덱스 조작할때는 StringBuffer 로 ?

## 새로운 객체 생성방법 ?

new 이외, getInstance(), valueOf()가 있음

## 배열관리

다음값 관리 (어디가 비어있는지?) -> 중간에 비면 땡겨서 맨뒤 empty
