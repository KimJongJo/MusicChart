package edu.kh.musicChart.playList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.musicChart.member.model.dto.Member;
import edu.kh.musicChart.playList.model.dto.PlayList;
import edu.kh.musicChart.playList.service.PlayListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PlayListService service = new PlayListService();

		try {
			
			HttpSession session = req.getSession();
			
			// 클릭한 플레이리스트 번호 받아오기
			int listNo = Integer.parseInt(req.getParameter("listNo"));
			
			// 현재 로그인한 회원 번호 받아오기
			Member member = (Member)session.getAttribute("member");
			int memberNo = member.getMemberNo();
			
			int result = service.delete(listNo, memberNo);
			
			if(result > 0) {

				session.setAttribute("message", "플레이 리스트에서 삭제 되었습니다");
				List<PlayList> playList = service.selectAll(member.getMemberNo());
				session.setAttribute("playList", playList);
				
				resp.sendRedirect("/");
				
			}else {
				
				session.setAttribute("message", "삭제되지 않았습니다!!");
				resp.sendRedirect("/");
				
			}
			
			
		}catch(Exception e) {
			System.out.println("[삭제 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
}
