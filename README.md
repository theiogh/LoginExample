## Login_Signup

학습을 위한 프로젝트입니다.  
로그인과 회원가입을 구현한 프로젝트입니다. 아래 영상을 참고했으며 이후 생각나는 기능들을 추가 구현했습니다.

참고한 영상 : [here](https://www.youtube.com/watch?v=ktjJ8xtt2Hg)

개발 환경 : 
 - Android Studio (JAVA)
 - 닷홈(무료 호스팅 제공)
 - PHPmyadmin
 - FileZilla(FTP)
 - Visual Studio Code(PHP)

## 구조

1. 메인

 로그인과 회원가입 창으로 이동시키는 기본적인 기능을 담고있습니다.
 
2. 로그인
 
 기본적으로 DB와 함께 로그인 기능을 담고있습니다. ( 영상을 참고했습니다. )  
 java.util.regex.Pattern클래스의 정적메소드 matches()메소드를 사용하여 정규 표현식으로 문자열을 검증했습니다.  
 아래는 실제 작성된 코드입니다.
 ```java
     String checkemail = et_Email.getText().toString();
        // 정규식 표현으로 이메일 형식을 나타냅니다.
        String regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        //matches 메소드로 비교할 대상들을 지정한 후 검증을 진행합니다.
        Boolean result = Pattern.matches(regExp, checkemail);

        // true, 올바른 이메일 형식일 때 실행.
        if (result){
            tv_email.setBackgroundResource(R.drawable.ic_email_after);
            et_Email.setTextColor(getResources().getColor(R.color.mycolor));
        }
        // false , 올바른 이메일 형식이 아닐 때 실행.
        else{
            tv_email.setBackgroundResource(R.drawable.ic_email_before);
            et_Email.setTextColor(getResources().getColor(R.color.red));
        }
 ```
 custom dialog를 생성하여 그 안에 비밀번호 찾기 기능을 추가 구현했습니다.  
 로그인 성공,실패 결과는 Toast메세지로 알려집니다.
  
3. 회원가입

 기본적으로 회원가입 기능을 담고있습니다.  
 로그인과 마찬가지로 문자열을 검증하는 기능을 담고있습니다.  
 회원가입 등록 성공,실패 결과는 Toast메세지로 알려집니다.  
 
4. UI

 편집은 Figma를 이용했습니다.  
 기본적인 UI는 다음과 같습니다.

<a href="#"><img src="https://github.com/theiogh/LoginExample/blob/master/app/src/main/res/Login_Signup_UI.png" width="1400px" alt="Login_Signup_UI"></a>
