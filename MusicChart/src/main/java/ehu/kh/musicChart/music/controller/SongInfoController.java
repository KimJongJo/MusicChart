package ehu.kh.musicChart.music.controller;

import java.io.IOException;

import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.music.service.MusicService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/songInfo")
public class SongInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		MusicService service = new MusicService();
		
		try {
			
			int songNo = Integer.parseInt(req.getParameter("songNo"));
			
			MusicChart musicChart = service.selectOne(songNo);

			req.setAttribute("musicChart", musicChart);
			
			req.getRequestDispatcher("/WEB-INF/views/songInfo.jsp").forward(req, resp);

		}catch(Exception e) {
			System.out.println("[노래 정보 보기 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}
	
}
