package edu.kh.musicChart.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int memberNo;			//회원 번호
	private String memberId;		//회원 아이디
	private String memberPw;		//회원 비밀번호
	private String memberNickname;	//회원 닉네임
	private char memberDelYn;		//회원 탈퇴여부
	
	// 탈퇴여부를 제외한 매개변수 생성자
	public Member(int memberNo, String memberId, String memberPw, String memberNickname) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
	}
	
	
}
