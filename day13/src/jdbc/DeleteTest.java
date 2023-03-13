package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

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
		String url = "jdbc:oracle:thin:@172.16.21.43:1521:XE";
		String deleteSql = "DELETE FROM cust WHERE id = ?";
		
		// Statement 생성 - SQL문 준비
		// SQL문 전송

		try(Connection con = DriverManager.getConnection(url, id, pwd); PreparedStatement pstmt = con.prepareStatement(deleteSql);) { 
			pstmt.setString(1, "id9");
			int result = pstmt.executeUpdate();
			// result에는 성공/실패여부가 boolean으로 들어감(예외로 표출xxx)
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 결과 받기

		// close

	}

}
