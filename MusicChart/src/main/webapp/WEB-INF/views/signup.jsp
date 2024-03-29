<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

    <link rel="stylesheet" href="/resources/css/signup_css.css">

    <script src="https://kit.fontawesome.com/b5ec955390.js" crossorigin="anonymous"></script>
</head>
<body>
    
        <div id="main">
        <div id="top">
            <span>JayJay Music</span><i class="fa-solid fa-music"></i>
        </div>
        <div id="under">
            <form action="/signup" id="form" method="post" onsubmit="return validate()">
                <div id="tool">
                    <div id="inner">
                        <table>
                            <tr>
                                <th>아이디</th>
                                <td><input type="text" class="btn" name="inputId" id="inputId" placeholder="4~13 한글,영어,숫자"></td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td><input type="password" class="btn" name="inputPw" id="inputPw"></td>
                            </tr>
                            <tr>
                                <th>비밀번호 확인</th>
                                <td><input type="password" class="btn" name="inputPw2" id="inputPw2"></td>
                            </tr>
                            <tr>
                                <th>이름(닉네임)</th>
                                <td><input type="text" class="btn" name="inputName" id="inputName"  placeholder="3~11 한글,영어,숫자"></td>
                            </tr>
                        </table>
                    </div>
					<span id="pwMessage">불일치</span>
                    
                </div>
                <!-- 회원가입 버튼 -->

                <a href="/" id="back-btn"><i class="fa-solid fa-arrow-left"></i></a>
                <button id="signup-btn">가입하기</button>
            </form>

        </div>

    </div>
    
    <script src="/resources/js/signup.js"></script>

</body>
</html> 