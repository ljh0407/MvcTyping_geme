package Typing_game.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import Typing_game.Controller.GControl;
import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;
import Typing_game.DTO.SginupDTO;


public class Typing_gameDAO {

	// 필드 
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Typing_gameDAO dao = new Typing_gameDAO();
	
	// 생성자
	public Typing_gameDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/typing_game",
					"root" , "1234"	);
		} catch (Exception e) {}
	}

	public static Typing_gameDAO getInstance() {return dao;}
	

	//private Typing_gameDAO() {}
	
	// 로그인
	public boolean 로그인(String mid, String pw) {
		
		String sql = "select * from member where mid = ? and pw = ?";
		try{
			ps =con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, pw);
			rs= ps.executeQuery();
			if(rs.next()) {
				GControl.getInstance().setLoginMno( rs.getInt(1)  );
				return true;
			}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
	// 중복체크
	
	public boolean idcheck( String mid) {
		String sql = "select * from member where mid =?";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, mid);
			rs= ps.executeQuery();
			if( rs.next()) {return true;}
			
			GControl.getInstance().setLoginMno(rs.getInt(1));
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 회원탈퇴
	public boolean 회원탈퇴() {
		String sql = "delete from member where mno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, GControl.getInstance().getLoginMno());
			ps.executeUpdate(); return true;
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	//  회원가입 
	
	public boolean 회원가입(SginupDTO Dto) {
		
		String sql= "insert into member values( null,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Dto.getMid());
			ps.setString(2, Dto.getPw());
			ps.setString(3, Dto.getMname());
			ps.setString(4, Dto.getMnn());
			ps.executeUpdate(); return true;
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 3. 문제출력
		
	
	public ArrayList<QuizDTO> read (){
		ArrayList<QuizDTO> list = new ArrayList<>();
		//String sql = "select * from quiz";
		String sql = "select * from quiz order by rand()";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				QuizDTO qdto = new QuizDTO(
						rs.getInt(1), rs.getString(2));
				list.add(qdto);
			}
			return list;
		} catch (Exception e) { System.out.println( e );}
		return list;
	}

	
	// 4. 랭킹보드
	public HashMap<String, Integer> Rangking(){
		HashMap<String, Integer> rangking = new HashMap<>();
		String sql = "select m.mnn 닉네임 , sum( s.ss ) 총점수 from score s , member m where s.mno = m.mno group by m.mnn order by sum(s.ss) desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				rangking.put( rs.getString(1) , rs.getInt(2)  );
				
			}// while end
			
			return rangking;
			
		} catch (Exception e) {System.out.println(e);
		}
		return rangking;
	}
	
	// 5. 점수저장 
	public boolean scoresave( int score ) {
		
		String sql = "insert into score(mno,ss) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, GControl.getInstance().getLoginMno());
			ps.setInt(2, score);
			ps.executeUpdate();return true;
		} catch (Exception e) {System.out.println(e);
		}return false;
		}
	
	// 6. 내기록보기
	public HashMap<Integer, String> playlog() {
		HashMap<Integer, String> log = new HashMap<>();
		String sql = "select * from score where mno = ? order by sdate desc";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, GControl.getInstance().getLoginMno() );
			rs = ps.executeQuery();
		while(rs.next()) {
			log.put(rs.getInt(2), rs.getString(3));
		}return log;
		} catch (Exception e) {System.out.println(e);};
		return log;
	}
			
			
	
	
}

