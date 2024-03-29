package edu.kh.musicChart.playList.model.dao;

import java.beans.Statement;
import java.io.Closeable;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.musicChart.music.model.dto.MusicChart;
import edu.kh.musicChart.playList.model.dto.PlayList;

import static edu.kh.musicChart.common.JDBCTemplate.*;

public class PlayListDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public PlayListDAO() {
		
		try {
			
			String filePath = PlayListDAO.class.getResource("/edu/kh/musicChart/sql/playList.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/** 플레이 리스트 조회
	 * @param conn
	 * @param memberNo
	 * @return playList
	 */
	public List<PlayList> selectAll(Connection conn, int memberNo) throws Exception{
		
		List<PlayList> playList = new ArrayList<PlayList>();
		PlayList play = null;
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				play = new PlayList(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6));
				
				playList.add(play);
				
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return playList;
	}


	/** 클릭한 노래 정보 받아오기
	 * @param conn
	 * @param songNo
	 * @return musicChart
	 */
	public MusicChart selectOne(Connection conn, int songNo) throws Exception{
		
		MusicChart musicChart = null;
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, songNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				musicChart = new MusicChart(songNo, rs.getString(1),
								rs.getString(2),
								rs.getString(3),
								rs.getInt(4),
								rs.getString(5));
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return musicChart;
	}

	/** 노래 추가하기
	 * @param conn
	 * @param songTitle
	 * @param songSinger
	 * @param songLyrics
	 * @param memberNo
	 * @return result
	 */
	public int append(Connection conn, String songTitle, String songSinger, String songLyrics, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("append");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, songTitle);
			pstmt.setString(2, songSinger);
			pstmt.setString(3, songLyrics);
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 노래 삭제
	 * @param conn
	 * @param listNo
	 * @return result
	 */
	public int delete(Connection conn, int listNo , int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, listNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
}
