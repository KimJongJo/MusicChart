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

@WebServlet("/singerSong")
public class SongSingerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MusicService service = new MusicService();
		
		try {
			
			String songSinger = req.getParameter("songSinger");
			
			List<MusicChart> musicList = service.sameSingerSongs(songSinger);
			
			// 해당 가수 이름 세팅
			req.setAttribute("songSinger", songSinger);
			// 해당 가수의 노래리스트 세팅
			req.setAttribute("musicList", musicList);
			
			req.getRequestDispatcher("/WEB-INF/views/singerInfo.jsp").forward(req, resp);
			
			
			
			
		}catch(Exception e) {
			
			System.out.println("[가사 정보 불러오는 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
	
	
}
