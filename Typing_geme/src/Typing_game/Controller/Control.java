package Typing_game.Controller;

import java.util.ArrayList;

import Typing_game.DAO.Typing_gameDAO;
import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;

public class Control {

	// 퀴즈 출력
	public ArrayList<QuizDTO>read(){
		return Typing_gameDAO.getInstance().read();
	}
	
	// 랭킹 입력?
	public RangkingDTO(0 , int ss) {
		return Typing_gameDAO.getInstance().Rangking(dto)
	};
	
}
