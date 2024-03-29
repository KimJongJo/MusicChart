package edu.kh.musicChart.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.musicChart.member.model.dto.Member;
import edu.kh.musicChart.member.service.MemberService;
import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.music.service.MusicService;
import edu.kh.musicChart.playList.model.dto.PlayList;
import edu.kh.musicChart.playList.service.PlayListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			Member member = service.login(inputId, inputPw);
			
			HttpSession session = req.getSession();
			
			// 로그인 성공
			if(member != null) {
				
				// 로그인 한 계정 session 객체에 저장
				session.setAttribute("member", member);
				
				// 노래 리스트 session 객체에 생성
				MusicService musicService = new MusicService();
				
				List<MusicChart> musicChart = musicService.selectAll();
				
				session.setAttribute("musicChart", musicChart);
				
				// 로그인 한 계정이 운영자 계정이면
				if(member.getMemberId().equals("0000")) {
					
					resp.sendRedirect("/plus");
					
					
				}else {// 로그인 한 계정이 일반 사용자 계정이라면
					
					
					// 저장된 플레이리스트 session 객체에 저장
					PlayListService listService = new PlayListService();
					
					List<PlayList> playList = listService.selectAll(member.getMemberNo());
					
					session.setAttribute("playList", playList);
					
					resp.sendRedirect("/");
				}
				
				
				
			}else { // 로그인 실패
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
			}
			
		}catch(Exception e) {
			System.out.println("[회원 정보 불러오는 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
}
