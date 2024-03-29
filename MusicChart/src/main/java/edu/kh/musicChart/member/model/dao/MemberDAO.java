package edu.kh.musicChart.member.model.dao;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.musicChart.member.model.dto.Member;
import static edu.kh.musicChart.common.JDBCTemplate.*;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO() {
		
		try {
		
			String filePath = MemberDAO.class.getResource("/edu/kh/musicChart/sql/member-sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/** 아이디 비번 있는지 확인후 member 반환
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return member
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception{
		
		Member member = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				member = new Member(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return member;
	}

	/** 회원가입 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @param inputName
	 * @return result
	 */
	public int signup(Connection conn, String inputId, String inputPw, String inputName) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signup");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			pstmt.setString(3, inputName);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}
	
}
