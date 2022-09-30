package Typing_game.Controller;

import Typing_game.DAO.Typing_gameDAO;
import Typing_game.DTO.SginupDTO;

public class GControl {

	private GControl() {}
	private static GControl control = new GControl();
	public static GControl getInstance() {return control;}
	
	
	
	
	
	
	public boolean 회원가입(SginupDTO Dto) {
		return Typing_gameDAO.getInstance().회원가입(Dto);
	}


	public boolean 로그인(String mid, String pw) {
		
		return Typing_gameDAO.getInstance().로그인(mid,pw);
	}
	
	

	
	
	
}
