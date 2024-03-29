<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/resources/css/singerInfo.css">
<script src="https://kit.fontawesome.com/b5ec955390.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<main>
		
		
        <a href="/plus" id="back"><i class="fa-solid fa-arrow-left" id="menu-btn"></i></a>
        <div id="tt">
            <span id="music-list">${songSinger}</span>
        </div>
        
	
		<table>
			<tr>
				<th>순위</th>
				<th>제목</th>
				<th>가수</th>
				<th>좋아요</th>
				<th><i class="fa-regular fa-thumbs-up" id="like-btn-size"></i></th>
				<th><i class="fa-solid fa-square-plus" id="btn-size"></i></th>
			</tr>
			
			<c:forEach var="music" items="${requestScope.musicList}">
			<tr>
				<td>${music.songNo}</td>
				<td><a href="/songInfo?songNo=${music.songNo}">${music.songTitle}</a></td>
				<td>${music.songSinger}</td>
				<td>${music.songLike}</td>
				<td><i class="fa-regular fa-heart"></i></td>
				<td><a href="/append?songNo=${music.songNo}"> + </a></td>
			</tr>
			
			</c:forEach>
			
		</table>
		
	</main>
	
</body>
</html>