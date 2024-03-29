package edu.kh.musicChart.music.model.dto;

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
public class MusicChart {

	private int songNo;			// 노래 번호			
	private String songTitle;	// 노래 제목
	private String songSinger;	// 노래 가수
	private String songLyrics;	// 노래 가사
	private int songLike;		// 좋아요 수
	private String songGenre;	// 노래 장르
	private String songDel;		// 노래 삭제 여부
	
	// 삭제 여부를 제외한 모든 매개변수 생성자
	public MusicChart(int songNo, String sontTitle, String songSinger, String songLyrics, int songLike,
			String songGenre) {
		super();
		this.songNo = songNo;
		this.songTitle = sontTitle;
		this.songSinger = songSinger;
		this.songLyrics = songLyrics;
		this.songLike = songLike;
		this.songGenre = songGenre;
	}
	
	
	
}
