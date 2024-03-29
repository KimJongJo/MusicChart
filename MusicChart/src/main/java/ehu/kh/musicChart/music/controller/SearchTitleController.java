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


@WebServlet("/searchTitle")
public class SearchTitleController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		
		MusicService service = new MusicService();
		
		HttpSession session = req.getSession();
		
		try {
			
			List<MusicChart> musicList = service.selectTitle(title);
			
			if(musicList.size() == 0) {
				
				session.setAttribute("message", "제목과 일치하는 곡이 존재하지 않습니다.");
				
				resp.sendRedirect("/plus");
			}else {
				req.setAttribute("musicList", musicList);
				
				req.getRequestDispatcher("/WEB-INF/views/titleSongs.jsp").forward(req, resp);
			}
			
		}catch(Exception e) {
			System.out.println("[제목 검색 중 예외발생]");
			e.printStackTrace();
		}
		
	}
	
}
