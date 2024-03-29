<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update</title>
	
	<link rel="stylesheet" href="/resources/css/update.css">
</head>
<body>
	
	<main>
		<h1>노래 수정</h1>
		
		<form action="/Update" method="post" id="form">
			<div>
				<span>제목 :</span>
				<input type="text" name="title" value="${music.songTitle}" required>
			</div>
			<div>
				<span>가수 :</span>
				<input type="text" name="singer" value="${music.songSinger}" required>
			</div>
			<div>
				<span>좋아요 :</span>
				<input type="number" name="like" value="${music.songLike}" required>
			</div>
			<input type="hidden" name="songNo" value="${music.songNo}">
			
			<button id="btn">수정하기</button>
		</form>
	
	</main>
	
</body>
</html>