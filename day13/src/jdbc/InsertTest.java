package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공");

		// Connect
		String id = "bank";
		String pwd = "111111";
		String url = "jdbc:oracle:thin:@172.16.21.59:1521:XE";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("Connection이 실패하였습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Connection 성공!!");
		
		// Statement 생성 - SQL문 준비
		// SQL문 전송

		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, "id15");
			pstmt.setString(2, "pwd15");
			pstmt.setString(3, "허명현");
			pstmt.setInt(4, 32);
			int result = pstmt.executeUpdate();
			//result에는 성공/실패여부가 boolean으로 들어감
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
					
		// 결과 받기

		// close
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("close 실패");
			e.printStackTrace();
		}
		System.out.println("close 성공");
		
	}

}
