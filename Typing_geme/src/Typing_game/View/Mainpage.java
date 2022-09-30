package Typing_game.View;

import java.util.Scanner;

import Typing_game.Controller.GControl;
import Typing_game.DTO.SginupDTO;

public class Mainpage {
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		Mainpage view = new Mainpage();
		view.메인페이지();
	}
	
	public void 메인페이지() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.로그아웃");
			int ch = scanner.nextInt();
			if( ch== 1 ) {회원가입();}
			if( ch== 2 ) {로그인();}
			if( ch== 3 ) {}
		}
	}
	
	public void 회원가입() {
		System.out.println("아이디 : "); String mid= scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("이름 : ");	String mname = scanner.next();
		System.out.println("닉네임 : "); String mnn = scanner.next();
		
		SginupDTO Dto = new SginupDTO(0, mid, pw, mname, mnn);
		
		boolean result = GControl.getInstance().회원가입(Dto);
		if(result) {System.out.println("회원가입 성공");}
		else {System.out.println("회원가입 실패");}
		
	}
	
	public void 로그인() {
		System.out.print("아이디 : "); String mid = scanner.next();
		System.out.print("비밀번호 :"); String pw = scanner.next();
		
		boolean result =GControl.getInstance().로그인(mid,pw);
		if(result) {System.out.println("로그인성공");}
		else {System.out.println("로그인실패");}
		
		
	}

	
	
}
