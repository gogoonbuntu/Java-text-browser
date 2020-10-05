#Java Text Web Browser!

a, img 에 번호를 부여해서,

a는 번호를 커맨드로 입력받으면 링크로 넘어가기,
img는 번호를 커맨드로 입력받으면 이미지 다운받기!

현재 링크를 배열로 저장해두고, empty한 switch문을 작성해놓았다.

오랜만에 java를 만지며 헷갈렸던 부분을 정리한다.

Array 는 추가/제거가 안되는 고정 배열, length()로 길이 호출
ArrayList 는 추가, 제거(add, delete)가 되는 배열, size()로 길이 호출
LinkedList 같은 기능을 하지만,
ArrayList 는 추가/제거 느림, 조회 빠름.
LinkedList 는 추가/제거 빠름, 조회 느림.

int to str :
* Integer.toString(숫자)

char/String to int :
* String.valueOf(문자열/캐릭터)

입력받기 :
* Scanner scan = new Scanner(System.in);