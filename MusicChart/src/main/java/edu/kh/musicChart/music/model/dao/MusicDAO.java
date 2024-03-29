package edu.kh.musicChart.music.model.dao;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.musicChart.music.model.dto.MusicChart;
import static edu.kh.musicChart.common.JDBCTemplate.*;

public class MusicDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MusicDAO() {
		
		try {
			
			String filePath = MusicDAO.class.getResource("/edu/kh/musicChart/sql/musicList.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	/** 노래 전체 조회
	 * @param conn
	 * @return musicList
	 */
	public List<MusicChart> selectAll(Connection conn) throws Exception{
		
		
		
		List<MusicChart> musicList = new ArrayList<MusicChart>();
		MusicChart music = null;
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				music = new MusicChart(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6));
				
				musicList.add(music);
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		return musicList;
	}

	/** 노래 정보 담기
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

	/** 해당 가수의 노래 리스트
	 * @param conn
	 * @param songSinger
	 * @return musicList
	 */
	public List<MusicChart> sameSingerSongs(Connection conn, String songSinger) throws Exception{
		
		List<MusicChart> musicList = new ArrayList<MusicChart>();
		MusicChart musicChart = null;
		
		try {
			
			String sql = prop.getProperty("sameSingerSongs");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, songSinger);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				musicChart = new MusicChart(rs.getInt(1),
									rs.getString(2),
									songSinger,
									rs.getString(3),
									rs.getInt(4),
									rs.getString(5));
				
				musicList.add(musicChart);
				
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return musicList;
	}



	/** 노래 수정
	 * @param conn
	 * @param title
	 * @param singer
	 * @param like
	 * @param songNo
	 * @return result
	 */
	public int update(Connection conn, String title, String singer, int like, int songNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, singer);
			pstmt.setInt(3, like);
			pstmt.setInt(4, songNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 제목으로 노래 찾기
	 * @param conn
	 * @param title
	 * @return musicList
	 */
	public List<MusicChart> selectTitle(Connection conn, String title) throws Exception{
		
		List<MusicChart> musicList = new ArrayList<MusicChart>();
		
		MusicChart music = null;
		
		try {
			
			String sql = prop.getProperty("selectTitle");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				music = new MusicChart(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6));
				
				musicList.add(music);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return musicList;
	}

	/** 가수로 노래찾기
	 * @param conn
	 * @param singer
	 * @return musicList
	 */
	public List<MusicChart> selectSinger(Connection conn, String singer) throws Exception{
		
		List<MusicChart> musicList = new ArrayList<MusicChart>();
		
		MusicChart music = null;
		
		try {
			
			String sql = prop.getProperty("selectSinger");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, singer);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				music = new MusicChart(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6));
				
				musicList.add(music);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return musicList;
	}
	
}
