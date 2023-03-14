package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class ItemDaoImpl implements DAO<String, String, Item> {

	public ItemDaoImpl() {
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
	public void insert(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(String k) throws Exception {
	}

	@Override
	public void update(Item v) throws Exception {
	}

	@Override
	public Item select(String k) throws Exception {
		Item item = null;
		try(Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectSql)){
			pstmt.setString(1, k);
			
			try (ResultSet rset = pstmt.executeQuery()){
				rset.next();
				String id = rset.getString("id");
				String name = rset.getString("name");
				int price = rset.getInt("price");
				double rate = rset.getDouble("rate");
				Date regdate = rset.getDate("regdate");
				item = new Item(id, name, price, rate, regdate);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			throw e;
		}
		return item;
	}

	@Override
	public List<Item> selectAll() throws Exception {
		List<Item> list = new ArrayList<Item>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemSelectAllSql);) {
			try (ResultSet rSet = pstmt.executeQuery();) {
				while (rSet.next()) {
					Item item = null;
					String id = rSet.getString("id");
					String name = rSet.getString("name");
					int price = rSet.getInt("price");
					double rate = rSet.getDouble("rate");
					Date regdate = rSet.getDate("regdate");

					item = new Item(id, name, price, rate, regdate);
					list.add(item);
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
	public List<Item> search(String k) throws Exception {
	return null;	
	}
}
