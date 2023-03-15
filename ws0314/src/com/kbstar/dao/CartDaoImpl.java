package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CartDaoImpl implements DAO<String, String, Cart> {

	public CartDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공");
	}

	@Override
	public void insert(Cart v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getUser_id());
			pstmt.setString(3, v.getItem_id());
			pstmt.setInt(4, v.getCnt());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartDeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e2) {
			throw e2;
		}
	}

	@Override
	public void update(Cart v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartUpdateSql);) {
			pstmt.setString(1, v.getUser_id());
			pstmt.setString(2, v.getItem_id());
			pstmt.setInt(3, v.getCnt());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("없는 id 업뎃 오류");
			}
		} catch (Exception e2) {
			throw e2;
		}
	}

	@Override
	public Cart select(String k) throws Exception {
		Cart cart = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartSelectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rSet = pstmt.executeQuery()) {
				rSet.next();
				String id = rSet.getString("id");
				String user_id = rSet.getString("user_id");
				String item_id = rSet.getString("item_id");
				int cnt = rSet.getInt("cnt");
				Date regdate = rSet.getDate("regdate");
				cart = new Cart(id, user_id, item_id, cnt, regdate);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return cart;
	}

	@Override
	public List<Cart> selectAll() throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartSelectAllSql);) {
			try (ResultSet rSet = pstmt.executeQuery();) {
				while (rSet.next()) {
					Cart cart = null;
					String id = rSet.getString("id");
					String user_id = rSet.getString("user_id");
					String item_id = rSet.getString("item_id");
					int cnt = rSet.getInt("cnt");
					Date regdate = rSet.getDate("regdate");

					cart = new Cart(id, user_id, item_id, cnt, regdate);
					list.add(cart);
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;

		}
		return list;
	}
	@Override
	public List<Cart> search(String k) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.myCartSelectAllSql);) {
			pstmt.setString(1, k);
			try (ResultSet rSet = pstmt.executeQuery();) {
				while (rSet.next()) {
					Cart cart = null;
					String id = rSet.getString("id");
					String user_id = rSet.getString("user_id");
					String item_id = rSet.getString("item_id");
					int cnt = rSet.getInt("cnt");
					Date regdate = rSet.getDate("regdate");

					cart = new Cart(id, user_id, item_id, cnt, regdate);
					list.add(cart);
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

}
