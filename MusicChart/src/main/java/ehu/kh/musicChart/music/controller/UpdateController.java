package ehu.kh.musicChart.music.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.music.service.MusicService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int songNo = Integer.parseInt(req.getParameter("songNo"));
		
		MusicService service = new MusicService();
		
		try {
			
			MusicChart music = service.selectOne(songNo);
			
			req.setAttribute("music", music);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			System.out.println("[노래 불러오는 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String singer = req.getParameter("singer");
		int like = Integer.parseInt(req.getParameter("like"));
		int songNo = Integer.parseInt(req.getParameter("songNo"));
		
		MusicService service = new MusicService();
		
		try {
			
			HttpSession session = req.getSession();
			
			int result = service.update(title, singer, like, songNo);
			
			if(result > 0) {
				
				session.setAttribute("message", "수정 되었습니다.");
				
				List<MusicChart> musicChart = service.selectAll(); 
				session.setAttribute("musicChart", musicChart);
				
				resp.sendRedirect("/plus");
				
			}else {
				
				session.setAttribute("message", "수정 실패!");
				
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		}catch(Exception e) {
			System.out.println("[노래 수정 중 예외 발생]");
			e.printStackTrace();
		}
		
		
		
	}
}
