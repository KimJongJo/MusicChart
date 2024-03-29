package edu.kh.musicChart.member.service;

import edu.kh.musicChart.member.model.dao.MemberDAO;
import edu.kh.musicChart.member.model.dto.Member;

import static edu.kh.musicChart.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return member
	 */
	public Member login(String inputId, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		Member member = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return member;
	}

	/** 회원가입 서비스
	 * @param inputId
	 * @param inputPw
	 * @param inputName
	 * @return result
	 */
	public int signup(String inputId, String inputPw, String inputName) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.signup(conn, inputId, inputPw, inputName);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
}
