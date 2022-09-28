package Typing_game.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Typing_gameDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Typing_gameDAO dao = new Typing_gameDAO();
	private Typing_gameDAO() {}
	public static Typing_gameDAO getInstance() {return dao;}
	
}
