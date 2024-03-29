package edu.kh.musicChart.member.controller;

import java.io.IOException;

import edu.kh.musicChart.member.model.dto.Member;
import edu.kh.musicChart.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// webapp 기준		
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			
			Member member = new Member();
			member.setMemberId(inputId);
			member.setMemberPw(inputPw);
			member.setMemberNickname(inputName);
			
			MemberService service = new MemberService();
			
			int result = service.signup(inputId, inputPw, inputName);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				
				session.setAttribute("message", "회원가입이 되었습니다!");
				resp.sendRedirect("/");
				
			}else {
				
				session.setAttribute("message", "회원가입이 실패했습니다!");
				resp.sendRedirect(req.getHeader("referer"));
				
			}
			
		}catch(Exception e) {
			System.out.println("[회원가입 중 예외발생]");
			e.printStackTrace();
		}
		
	}
		
}
