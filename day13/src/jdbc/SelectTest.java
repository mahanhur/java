package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

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
		String selectSql = "SELECT * FROM cust WHERE id = ?";
		
		// Statement 생성 - SQL문 준비
		// SQL문 전송

		try(Connection con = DriverManager.getConnection(url, id, pwd); PreparedStatement pstmt = con.prepareStatement(selectSql);) { 
			pstmt.setString(1, "id29");
			try(ResultSet rSet = pstmt.executeQuery()) {
				rSet.next(); // ResultSet은 한칸 위의 공간을 가르키고 있으므로 반드시 next로 한 칸 내려줘야함
				String db_id = rSet.getString("id"); //()안에는 index+1을 가르키거나 실제 컬럼명을 써주면 됨
				String db_pwd = rSet.getString("pwd");
				String name = rSet.getString("pwd");
				int age = rSet.getInt("age");
				System.out.println(db_id + "  " + name + "  " + age);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
