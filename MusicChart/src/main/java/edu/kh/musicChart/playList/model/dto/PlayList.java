package edu.kh.musicChart.playList.model.dto;

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
public class PlayList {
	private int listNo;			// 플레이리스트 번호
	private String songTitle;	// 노래 제목
	private String songSinger;	// 노래 가수
	private String songLyrics;	// 노래 가사
	private String songLikeCh;	// 좋아요 표시 여부
	private char listDel;		// 삭제 여부
	private int memberNo;		// 회원 번호
	
	
	
	public PlayList(int listNo, String songTitle, String songSinger, String songLyrics, String songLikeCh, int memberNo) {
		super();
		this.listNo = listNo;
		this.songTitle = songTitle;
		this.songSinger = songSinger;
		this.songLyrics = songLyrics;
		this.songLikeCh = songLikeCh;
		this.memberNo = memberNo;
	}
	
	
	
	
}
