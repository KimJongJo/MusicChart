package edu.kh.musicChart.playList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.musicChart.member.model.dto.Member;
import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.playList.model.dto.PlayList;
import edu.kh.musicChart.playList.service.PlayListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/append")
public class AppendController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PlayListService service = new PlayListService();
		
		try {
			
			HttpSession session = req.getSession();
			
			// 클릭한 노래 번호 받아오기
			int songNo = Integer.parseInt(req.getParameter("songNo"));
			
			// 현재 로그인한 회원 번호 받아오기
			Member member = (Member)session.getAttribute("member");
			int memberNo = member.getMemberNo();
			
			
			// MusicChart music = (MusicChart)session.getAttribute("musicChart");
			
			MusicChart musicChart = service.selectOne(songNo);
			
			String songTitle = musicChart.getSongTitle();
			String songSinger = musicChart.getSongSinger();
			String songLyrics = musicChart.getSongLyrics();
			
			int result = service.append(songTitle, songSinger, songLyrics, memberNo);

			
			if(result > 0) {
				session.setAttribute("message", "추가되었습니다");

				List<PlayList> playList = service.selectAll(member.getMemberNo());
				session.setAttribute("playList", playList);
				
				resp.sendRedirect("/plus");
				
			}else {
				
				session.setAttribute("message", "노래 추가 실패!!");
				
				resp.sendRedirect(req.getHeader("referer"));
				
			}
			
		}catch(Exception e) {
			System.out.println("[노래 추가 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
}
