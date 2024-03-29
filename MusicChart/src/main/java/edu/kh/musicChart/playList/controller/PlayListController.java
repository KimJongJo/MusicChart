package edu.kh.musicChart.playList.controller;

import java.io.IOException;

import edu.kh.musicChart.member.model.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/plus")
public class PlayListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Member member = (Member)session.getAttribute("member");
		
		if(member.getMemberId().equals("0000")) {
			req.getRequestDispatcher("/WEB-INF/views/operator.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/views/musicPlus.jsp").forward(req, resp);
		}
		
		
		
	}
	
}
