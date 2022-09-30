package Typing_game.View;


import java.util.ArrayList;
import java.util.Scanner;

import Typing_game.Controller.Control;
import Typing_game.DTO.QuizDTO;
public class Mainpage {

	Scanner scanner = new Scanner(System.in);
	Control control = new Control();
	private static Mainpage mainp = new Mainpage();
	private Mainpage() {}
	private Mainpage getInstance() {return mainp;}

	
	public static void main(String[] args) { 
		Mainpage Main = new Mainpage();
		Main.mainpage();
	}// main end
	
	void mainpage() {
		while (true) {
			System.out.println("==============타자게임=============");
			System.out.println("1.회원가입\t2.게임하기3.랭킹순위");
			int ch = scanner.nextInt();
			
			if( ch == 1) {}
			else if ( ch == 2 ) {quiz();}
			else if ( ch == 3 ) {}
			
		}
		
	}
	
	
	// 1. 회원가입
	
	
	
	
	
	// 2. 퀴즈출력
	void quiz() {
		System.out.println("화면에 나오는 글자를 똑같이 치세요.");
		
		ArrayList<QuizDTO> list = control.read();
			System.out.println("번호\t문제");
			int score = 0;
			for( QuizDTO qdto : list) {
				System.out.println(qdto.getQno());
				System.out.println(qdto.getQmsg());
				String input = scanner.next();//행동
				if(qdto.getQmsg().equals(input) ) {
					score++;
					System.out.println("정답."+score);
					
				}else {System.out.println("오답"+score);}
			
				
				
				/*
				 * if(score += 1) { System.out.println("정답입니다."+score+"점수 : "); score++; }else
				 * {System.out.println("틀렸습니다.");}
				 */
			}// for end	
			
			System.out.println("문제 끝" + score+"점" );
				
			//랭킹순위
			
			
			
				
				
				
			} // 퀴즈출력 end
		
	
	void Rangking() {}
	
	}
	
	
	

