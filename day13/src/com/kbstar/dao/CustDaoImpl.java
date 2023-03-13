package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kbstar.dto.Cust;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {
	// 드라이버 로딩
	public CustDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공");
	}

	// 커넥션
	public static Connection getConnection() throws Exception {
		Connection con = null;

		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL");
		con = DriverManager.getConnection(url, id, pwd);
		return con;
	}

	@Override
	public void insert(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new SQLException("똑같은 아이디 insert 입력 오류(dao표출)"); // 여기서 오류를 표출하면 실제 APP에서는 오류있는지 없는지 모르므로 throw를 해준다
//			e1.printStackTrace();
		}

	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.deleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new SQLException("없는 id 삭제 -dao 오류(result0)");
			}
//			System.out.println(result);
		} catch (SQLException e2) {
//			e2.printStackTrace();
			throw new SQLException("dao 오류");
		}
	}

	@Override
	public void update(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getAge());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("없는 id 업뎃 -dao 오류(result0)");
			}
//			System.out.println(result);
		} catch (Exception e2) {
//			e2.printStackTrace();
			throw new Exception("dao 오류");
		}
	}

	@Override
	public Cust select(String k) throws Exception {
		Cust cust = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			pstmt.setString(1, k);
			ResultSet rSet = pstmt.executeQuery();
			rSet.next();
			String DB_ID = rSet.getString("id");
			String DB_PWD = rSet.getString("pwd");
			String DB_NAME = rSet.getString("name");
			int DB_AGE = rSet.getInt("age");
			cust = new Cust(DB_ID, DB_PWD, DB_NAME, DB_AGE);
			return cust;
		} catch (Exception e) {
			throw new Exception("dao 오류");
		}
	}

	@Override
	public List<Cust> selectAll() throws Exception {
		ArrayList<Cust> list = new ArrayList<Cust>();
		Cust cust = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql);) {
			try (ResultSet rSet = pstmt.executeQuery();) {

				while (rSet.next()) {
					String DB_ID = rSet.getString("id");
					String DB_PWD = rSet.getString("pwd");
					String DB_NAME = rSet.getString("name");
					int DB_AGE = rSet.getInt("age");
					cust = new Cust(DB_ID, DB_PWD, DB_NAME, DB_AGE);
					list.add(cust);
				}
				return list;
			} catch (Exception e) {
				throw new Exception("dao 오류");
			}
		} catch (Exception e) {
			throw new Exception("dao 오류");
		}
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		return null;
	}

}
