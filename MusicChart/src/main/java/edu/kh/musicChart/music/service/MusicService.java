package edu.kh.musicChart.music.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.musicChart.music.model.dao.MusicDAO;
import edu.kh.musicChart.music.model.dto.MusicChart;
import static edu.kh.musicChart.common.JDBCTemplate.*;

public class MusicService {
	
	private MusicDAO dao = new MusicDAO();

	/** 모든 노래 담기
	 * @return musicList
	 */
	public List<MusicChart> selectAll() throws Exception{
		
		Connection conn = getConnection();
		
		List<MusicChart> musicList = dao.selectAll(conn);
		
		close(conn);
		
		
		return musicList;
	}
 
	/** 노래 정보 담기
	 * @param songNo
	 * @return musicChart
	 */
	public MusicChart selectOne(int songNo) throws Exception{
		
		Connection conn = getConnection();
		
		MusicChart musicChart = dao.selectOne(conn, songNo);
		
		close(conn);
		
		return musicChart;
	}

	/** 해당 가수의 노래 리스트
	 * @param songSinger
	 * @return musicList
	 */
	public List<MusicChart> sameSingerSongs(String songSinger) throws Exception{
		
		Connection conn = getConnection();
		
		List<MusicChart> musicList = dao.sameSingerSongs(conn, songSinger);
		
		close(conn);
		
		return musicList;
		
	}



	/** 노래 수정
	 * @param title
	 * @param singer
	 * @param like
	 * @param songNo
	 * @return result
	 */
	public int update(String title, String singer, int like, int songNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.update(conn, title, singer, like, songNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 제목으로 노래 찾기
	 * @param title
	 * @return musicList
	 */
	public List<MusicChart> selectTitle(String title) throws Exception{
		
		Connection conn = getConnection();
		
		List<MusicChart> musicList = dao.selectTitle(conn, title);
		
		close(conn);
		
		return musicList;
	}

	/** 가수로 노래 찾기
	 * @param singer
	 * @return musicList
	 */
	public List<MusicChart> selectSinger(String singer) throws Exception{
		
		Connection conn = getConnection();
		
		List<MusicChart> musicList = dao.selectSinger(conn, singer);
		
		close(conn);
		
		return musicList;
	}
	
}
