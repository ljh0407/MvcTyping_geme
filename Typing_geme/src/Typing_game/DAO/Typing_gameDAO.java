package Typing_game.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	// 1. 회원가입
	
	
	
	
	// 2. 회원가입 출력
	
	
	// 3. 문제출력
	public ArrayList<QuizDTO> read (){
		ArrayList<QuizDTO> list = new ArrayList<>();
		String sql = "select * from quiz";
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
	boolean Rangking(RangkingDTO rdto) {
		String sql = "insert into score values(null , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, rdto.getSs());
			ps.executeQuery(); return true;
		} catch (Exception e) {
			System.out.println("DB오류 " + e);
			return false;
		}
		
		
	}
	
	

	
	

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
	
	public boolean 로그인(String mid, String pw) {
		
		String sql = "select * from member where mid = ? and pw = ?";
		try{
			ps =con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, pw);
			rs= ps.executeQuery();
			if(rs.next()) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}




}

