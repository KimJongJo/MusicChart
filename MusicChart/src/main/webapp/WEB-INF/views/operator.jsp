<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operator Mode</title>

<link rel="stylesheet" href="/resources/css/operator.css">

<script src="https://kit.fontawesome.com/b5ec955390.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<main>
        <div id="top">
        	<a href="logout" id="logout-btn">로그아웃</a>
            <span id="music-list">운영자 모드</span>
        </div>
	
		<table>
			<tr>
				<th>순위</th>
				<th>제목</th>
				<th>가수</th>
				<th>좋아요</th>
				
			</tr>
			
			<c:forEach var="music" items="${sessionScope.musicChart}">
			<tr>
				<td><a href="/Update?songNo=${music.songNo}">${music.songNo}</a></td>
				<td><a href="/Update?songNo=${music.songNo}" class="btn">${music.songTitle}</a></td>
				<td><a href="/Update?songNo=${music.songNo}" class="btn">${music.songSinger}</a></td>
				<td><a href="/Update?songNo=${music.songNo}">${music.songLike}</a></td>
			</tr>
			
			</c:forEach>
			
		</table>
		
	</main>	
	
	<c:if test="${not empty sessionScope.message}">
    
    	<script>
    		alert('${message}');
    	</script>
    	
    	<c:remove var="message" scope="session" />
    </c:if>
	
	
</body>
</html>