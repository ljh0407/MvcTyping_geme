package Typing_game.Controller;

import Typing_game.DAO.Typing_gameDAO;
import Typing_game.DTO.SginupDTO;

public class GControl {
	
	private int loginMno = 0; // 로그인 성공한 회원의 번호 저장하는 변수 
	
	public int getLoginMno() {
		return loginMno;
	}


	public void setLoginMno(int loginMno) {
		this.loginMno = loginMno;
	}


	public static GControl getControl() {
		return control;
	}


	public static void setControl(GControl control) {
		GControl.control = control;
	}


	private GControl() {}
	private static GControl control = new GControl();
	public static GControl getInstance() {return control;}
	
	private int LoginMno = 0;

	
	public int 회원가입(SginupDTO Dto) {
		boolean result = Typing_gameDAO.getInstance().idcheck(Dto.getMid());
		if (result) {return 3;}
		else {
		boolean result2 = Typing_gameDAO.getInstance().회원가입(Dto);
		if(result2) {return 1;}
		else {return 2;}
		}
	}

	public boolean 로그인(String mid, String pw) {  // 잘못클릭했어요 이어서 하세요 네
		
		return Typing_gameDAO.getInstance().로그인(mid,pw);
	}
	
	 public boolean 회원탈퇴() {
		 return Typing_gameDAO.getInstance().회원탈퇴();
	 }

	
	
}
