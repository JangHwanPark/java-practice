## All
- [x] 로그인
- 로그아웃

## Admin
- [x] 상품 등록
- 상품 삭제
- 상품 수정

## User
- [x] 상품 선택 (장바구니에 담기)
- 장바구니 조회
  - 수정 필요
- 결제 / 쇼핑 계속
  - 구현 필요

## CLI
- [x] Terminal Design (./Utils/CLIColor)
- [x] Register/Login (./Service/ServiceUser)
- [x] View (View/ViewCLI)

## GUI
- [ ] JavaFx 로 구현 예정
  - [ ] 레이아웃

## 디자인 패턴?
- DAO?
  - Data Access Obj 약어로 디비 접근하려고 만드는 객체
  - DB에 접근하고 씨알유디 작업 수행
- DTO?
  - Data Transfer Obj 약어로 계층간? 데이터를 교환하기 위한 자바빈즈(자바로 만든 컴포넌트)다.
  - 게터 세터만 존재해야함
- DAO 로 데이터 받아와서 DTO 로 인스턴스 만든다음 비즈니스로직(service)로 보낸다음 뷰나 프론트 엔드포인트로 넘겨주는듯