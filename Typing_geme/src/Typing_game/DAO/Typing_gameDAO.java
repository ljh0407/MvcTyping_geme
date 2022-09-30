package Typing_game.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Typing_game.DTO.SginupDTO;

public class Typing_gameDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Typing_gameDAO dao = new Typing_gameDAO();

	private Typing_gameDAO() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/typing_game",
					"root",
					"1234"
					);
			
			
		}catch (Exception e) {System.out.println("연동실패"+e);}
		
	}
	
	
	
	public static Typing_gameDAO getInstance() {return dao;}
	
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
