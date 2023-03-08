package com.kbstar.dao;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<Integer, ItemDTO>{

	@Override
	public void insert(ItemDTO v) throws Exception{
		if (v.getId() == 1235) {
			throw new Exception("EX0007");
		}
		connect();
		System.out.println(v);
		System.out.println("Inserted...");
		close();
	}

	@Override
	public void delete(Integer k) throws Exception{
		if(k == 1235) {
			throw new Exception("EX0008");
		}
		System.out.println(k);
		System.out.println("Deleted...");
		
	}

	@Override
	public void update(ItemDTO v) throws Exception {
		if (v.getId() == 1235) {
			throw new Exception("EX0007");
		}
		System.out.println(v);
		System.out.println("Updated...");
		
	}


}
