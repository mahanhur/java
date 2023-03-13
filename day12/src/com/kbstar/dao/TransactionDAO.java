package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;

public class TransactionDAO implements DAO<String, TransactionDTO>{

	HashMap<String, TransactionDTO> db;
	public TransactionDAO() {
		db = new HashMap<String, TransactionDTO>();
	}
	
	@Override
	public void insert(TransactionDTO v) throws Exception {
		if(db.containsKey(v.getDate())) {
			throw new Exception("ER001");
		}
		db.put(v.getDate(), v);
	}

	@Override
	public void delete(String k) throws Exception {
	}

	@Override
	public void update(TransactionDTO v) throws Exception {
	}

	@Override
	public TransactionDTO select(String k) throws Exception {
		TransactionDTO data = null;
		if(!db.containsKey(k)) {
			System.out.println("ER002");
		}
			data = db.get(k);
			return data;
			
	}

	@Override
	public List<TransactionDTO> select() throws Exception {
		ArrayList<TransactionDTO> list = new ArrayList<TransactionDTO>();
		Collection<TransactionDTO> col = db.values();
		for (TransactionDTO data :col) {
			list.add(data);
		}
		return list;
	}

	//모든 거래내역 중 특정 accNo의 Tr만 return한다
	
	@Override
	public List<TransactionDTO> search(Object obj) throws Exception {
		return null;
	}

}
