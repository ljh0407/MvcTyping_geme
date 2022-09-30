package Typing_game.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;

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
	boolean Rangking(RangkingDTO dto) {
		String sql = "insert into score values(null , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getSs());
			ps.executeUpdate(); return true;
		} catch (Exception e) {
			System.out.println("DB오류 " + e);
			return false;
		}
		
		
	}
	
	
}// m end
	
	
	
