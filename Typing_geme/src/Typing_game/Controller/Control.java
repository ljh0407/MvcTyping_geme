package Typing_game.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Typing_game.DAO.Typing_gameDAO;
import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;

public class Control {

	// 퀴즈 출력
	public ArrayList<QuizDTO>read(){
		return Typing_gameDAO.getInstance().read();
	}
	
	// 점수 저장 
	public boolean scoresave( int score  ) {
		return Typing_gameDAO.getInstance().scoresave( score);
	}
	
	// 랭킹 
	public HashMap< String , Integer > Rangking( ) {
		return Typing_gameDAO.getInstance().Rangking(  );
	}
	
}
