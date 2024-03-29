package edu.kh.musicChart.playList.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.playList.model.dao.PlayListDAO;
import edu.kh.musicChart.playList.model.dto.PlayList;
import static edu.kh.musicChart.common.JDBCTemplate.*;

public class PlayListService {
	
	private PlayListDAO dao = new PlayListDAO();

	/** 노래 전체조회
	 * @param memberNo
	 * @return playList
	 * @throws Exception
	 */
	public List<PlayList> selectAll(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<PlayList> playList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return playList;
	}


	/** 클릭한 노래 정보 받기
	 * @param songNo
	 * @return musicChart
	 */
	public MusicChart selectOne(int songNo) throws Exception{
		
		Connection conn = getConnection();
		
		MusicChart musicChart = dao.selectOne(conn, songNo);
		
		close(conn);
		
		return musicChart;
	}

	/** 노래 추가하기
	 * @param songTitle
	 * @param songSinger
	 * @param songLyrics
	 * @param memberNo
	 * @return result
	 */
	public int append(String songTitle, String songSinger, String songLyrics, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.append(conn, songTitle, songSinger, songLyrics, memberNo);
		
		close(conn);
		
		return result;
	}


	/** 노래 삭제
	 * @param listNo
	 * @return delete
	 */
	public int delete(int listNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.delete(conn, listNo, memberNo);
		
		close(conn);
		
		return result;
	}
	
}
