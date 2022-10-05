package Typing_game.View;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Typing_game.Controller.Control;
import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;
import Typing_game.Controller.GControl;
import Typing_game.DTO.SginupDTO;

public class Mainpage {
	Scanner scanner = new Scanner(System.in);
	Control control = new Control();
	private static Mainpage mainp = new Mainpage();
	private Mainpage() {}
	private Mainpage getInstance() {return mainp;}

	public static void main(String[] args) {
		
		Mainpage view = new Mainpage();
		view.메인페이지();
	}
	
	public void 메인페이지() {
		while(true) {
			System.out.println("1.회원가입 2.로그인" );
			int ch = scanner.nextInt();
			if( ch== 1 ) {회원가입();}
			if( ch== 2 ) {로그인();}
			
		}
	}
	
	//  회원가입
	public void 회원가입() {
		System.out.println("아이디 : "); String mid= scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("이름 : ");	String mname = scanner.next();
		System.out.println("닉네임 : "); String mnn = scanner.next();
		
		SginupDTO Dto = new SginupDTO(0, mid, pw, mname, mnn);
		
		int result = GControl.getInstance().회원가입(Dto);
		if(result ==1) {System.out.println("회원가입 성공");}
		else if (result ==2){System.out.println("회원가입 실패");}
		else if (result == 3) {System.out.println("사용중인 아이디입니다");}
	}
	
	// 로그인
	public void 로그인() {
		System.out.print("아이디 : "); String mid = scanner.next();
		System.out.print("비밀번호 :"); String pw = scanner.next();
		
		
		boolean result =GControl.getInstance().로그인(mid,pw);
		if(result) {
			System.out.println("로그인성공");
			mainpage();
		}
		if(result) {System.out.println("로그인성공");mainpage();}

		else {System.out.println("로그인실패");}
		
		
	}


	
	// 메인페이지
	public void 회원탈퇴() {
		System.out.println("정말 탈퇴하시겠습니까 [예/아니오]");
		String button = scanner.next();
		if(button.equals("예")){
			boolean result= GControl.getInstance().회원탈퇴();
			if(result) {
				System.out.println("회원탈퇴 성공[로그아웃됩니다]");
			}else {
			System.out.println("회원실패[관리자 문의]");
		}
		return;
		}
		System.out.println("[예]입력시 탈퇴가 진행 됩니다. [탈퇴실패/로그아웃 됩니다]");
	}
	

	void mainpage() {
		while (true) {
			System.out.println("==============타자게임=============");

			System.out.println("1.로그아웃\t2.게임하기3.랭킹순위");

			System.out.println("1.로그아웃 2.게임하기 3.랭킹순위 5.회원탈퇴");

			int ch = scanner.nextInt();
			

			if( ch == 1) { GControl.getInstance().setLoginMno(0); return;  }

			if( ch == 1) {GControl.getInstance().setLoginMno(0);
			System.out.println("로그아웃 되었습니다");
			return; }
			

			else if ( ch == 2 ) {quiz();}
			else if ( ch == 3 ) {Rangking();}
			else if ( ch == 5) { 회원탈퇴(); return; }
		}
		
	}
	
	

	
	
	//  퀴즈출력
	void quiz() {
		System.out.println("화면에 나오는 글자를 똑같이 치세요.");
		
		ArrayList<QuizDTO> list = control.read();
			System.out.println("번호\t문제");
			int score = 0; // 텍스트 글자수별로 조깨 점수를 준다..??
			
			
			for( QuizDTO qdto : list) {					// 문제가 하나씩 출력된다.. 
				System.out.print(qdto.getQno() +"\t");
				System.out.print(qdto.getQmsg() +"\n");
				
				String input = scanner.next(); // 문제를 보고 입력한다. 
						// 문자열.charAt(인덱스) : 해당 인덱스의 문자[1개]만 추출 메소드 
				
				int 맞힌수 = 0;
				int 틀린수 = 0;
				for( int j = 0 ; j<qdto.getQmsg().length() ; j++ ) { // 문제의 문자열 만큼 반복한다. 
					if( input.length() > j &&  ( qdto.getQmsg().charAt(j) == input.charAt(j) )  ) {
						맞힌수++;
					}// if end
					else {// ??? 너무 복잡하게 생각하셨어요
						틀린수++;
					}
				}// for end
				System.out.println( "총 : " +맞힌수+ " 글자 맞힘  /  " + 틀린수 +" 글자 틀림" );
				score += (맞힌수-틀린수);
				System.out.println(" 현재 점수 : " + score );
				if( score < 0 ) { System.out.println(" [ 게임아웃 ] "); return; }
			} // for end
			System.out.println("문제 총점 : " + score+"점" );
			// 점수를 db에 저장하자~!!
			control.scoresave( score );
			
	} // 퀴즈출력 end
			
	
	
//	for( int j = 0 ; j<qdto.getQmsg().length() ; j-- ) { // 문제의 문자열 만큼 반복한다. 
//		
//		if( input.length() > j &&  ( qdto.getQmsg().charAt(j) != input.charAt(j) )  ) {
//			partscore--;
//		}// if end
//		
//		if(j < 0 ) {System.out.println("게임이 종료됩니다.");}
//	}// for end	
//	score -= partscore;
			
		 
		
	//랭킹순위
	
	void Rangking() {
		
		HashMap< String , Integer > rangking = control.Rangking();
		
		System.out.println("순위\t닉네임\t점수"); 
		int 순위 = 0;
		for( String key  : rangking.keySet() ) {
			순위++;
			System.out.print( 순위 + "\t");
			System.out.print( key +"\t" );
			System.out.println( rangking.get(key) +"\n" );
		}
		
		
	} // Rangking end
	
	}
	
	
	

