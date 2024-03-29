<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노래 정보</title>
<script src="https://kit.fontawesome.com/b5ec955390.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/songInfo_css.css">

</head>
<body>
	
	<main>
		<a href="/plus" id="back-btn"><i class="fa-solid fa-arrow-left"></i></a>
		
		<div id="all">
			<div id="top">
				<!-- 제목 -->
				<span id="title">${requestScope.musicChart.songTitle}</span>
				<div>
					<!-- 가수 -->
				<span id="singer">${requestScope.musicChart.songSinger}</span>
				<!-- 장르 -->
				<span id="genre">${requestScope.musicChart.songGenre}</span>
				</div>
				
			</div>
			<div id="second">
				<span>좋아요 수 : </span>
				<span id="like">${requestScope.musicChart.songLike}</span>
			</div>
			
			<!-- 가사 -->
			<div id="lay">${requestScope.musicChart.songLyrics}</div>
		</div>
	</main>
	
</body>
</html>