<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JayJay Music</title>
    <link rel="stylesheet" href="/resources/css/music_css.css">

    <script src="https://kit.fontawesome.com/b5ec955390.js" crossorigin="anonymous"></script>
    
</head>
<body>

	<main>
	
		<c:choose>
			<%-- 로그인 안했으면 로그인/회원가입 화면 출력 --%>
			<c:when test="${empty sessionScope.member}">
				<div id="main">
			        <div id="top">
			            <span>JayJay Music</span><i class="fa-solid fa-music"></i>
			        </div>
			        <div id="under">
			            <form action="/login" id="form" method="post">
			                <div id="inner">
			                    <input type="text" class="btn" name="inputId"  autocomplete="off">
			                    <input type="password" class="btn" name="inputPw">
			                </div>
			                <!-- 로그인 버튼 -->
			                <button id="login-btn">로그인</button>
			            </form>
			            <!-- 회원가입 -->
			            <a href="/signup" id="signup-btn">회원가입</a>
			        </div>
			        <div id="bottom">
			            <span>v.0.0.0</span>
			        </div>
			    </div>				
			</c:when>
			
			
			<%-- 로그인 했을때 로그인 한 계정의 재생목록 + 노래차트 출력 --%>
			<c:otherwise>
				<h1 id="list-title">${member.memberNickname}의 플레이리스트</h1>
	            <div id="second">
	                <a href="logout" id="logout-btn">로그아웃</a>
	                <a href="plus" id="plus-btn">노래 추가하기</a>
	            </div>	        
				
				<c:choose>
					<c:when test="${empty sessionScope.playList}">
						<h2 id="list-none">플레이리스트가 비어있습니다</h2>
						
					</c:when>
					<c:otherwise>
						<table id="table">
							<tr>
								<th>제목</th>
								<th>가수</th>
								<th>좋아요</th>
							</tr>
							
							<c:forEach var="play" items="${playList}">
							<tr>
								<td>${play.songTitle}</td>
								<td>${play.songSinger}</td>
								<td>${play.songLikeCh}</td>
								<td><a href="/delete?listNo=${play.listNo}"> X </a></td>
							</tr>
							</c:forEach>
							
						</table>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
			
		</c:choose>
		
		
	</main>
	
	
    <div>
        <div id="function">
            <p>C : 회원가입</p>
            <p>R : 제목, 가수이름으로 노래 조회</p>
            <p>U : 운영자 계정으로 노래 수정</p>
            <p>D : 플레이 리스트에서 제거</p>
        </div>
        

        <h3>운영자 계정 아이디, 비밀번호 : 0000</h3>
        <p>운영자만 노래 정보에 대한 수정이 가능함</p>
    </div>   

    
    
    
    <c:if test="${not empty sessionScope.message}">
    
    	<script>
    		alert('${message}');
    	</script>
    	
    	<c:remove var="message" scope="session" />
    </c:if>
    
    
    
</body>
</html> 