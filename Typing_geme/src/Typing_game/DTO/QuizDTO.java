package Typing_game.DTO;

public class QuizDTO {
	// 필드
	int qno ;
	String qmsg;
	
	// 생성자
	public QuizDTO(int qno, String qmsg) {
		super();
		this.qno = qno;
		this.qmsg = qmsg;
	}
	// 메소드

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQmsg() {
		return qmsg;
	}

	public void setQmsg(String qmsg) {
		this.qmsg = qmsg;
	}
	
	
	
	
	
	
}
