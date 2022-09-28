package Typing_game.View;

import java.util.Scanner;

public class Mainpage {
	Scanner scanner = new Scanner(System.in);
	
	void menu() {
		
		System.out.println("1.회원가입 2. 3.랭킹보기");
		
		int btn = scanner.nextInt();
		if(btn==1) {}
		
	}
	
	void sginup() {
		System.out.println("아이디 :");String mid = scanner.next();
		System.out.println("비밀번호 :"); String pw = scanner.next();
		System.out.println("이름 :");String mname =scanner.next();
		System.out.println("닉네임 : ");String mnn = scanner.next();
		
	}
	
}
