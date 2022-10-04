package Typing_game.DTO;

public class SginupDTO {

	private int mno;
	private String mid;
	private String pw;
	private String mname;
	private String mnn;
	
	public SginupDTO(int mno, String mid, String pw, String mname, String mnn) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.pw = pw;
		this.mname = mname;
		this.mnn = mnn;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMnn() {
		return mnn;
	}

	public void setMnn(String mnn) {
		this.mnn = mnn;
	}
	
	
	
}
