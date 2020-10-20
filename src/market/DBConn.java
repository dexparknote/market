package market;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {//공통모듈 - 프로젝트에 하나만 있으면됨
	//Field
	private String url= "jdbc:oracle:thin:@127.0.0.1:1521";
	private String user = "scott";
	private String pass = "tiger";
	
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	//Constructor
	public DBConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1--------------->> 드라이버 로딩 성공");
			
			conn=DriverManager.getConnection(url, user, pass);
			System.out.println("2--------------->> Connection 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Statement 객체 생성
	public void getStatement() {
		try {
			stmt=conn.createStatement();
			System.out.println("3--------------->> Statement 생성");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//PreparedStatement 객체 생성
	public void getPreparedStatement(String sql) {
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println("3--------------->> PreparedStatement 생성");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//객체 close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			System.out.println("6------------>> 객체 close완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}//class
