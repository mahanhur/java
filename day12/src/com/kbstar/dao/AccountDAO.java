package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class AccountDAO implements DAO<String, AccountDTO> {
	HashMap<String, AccountDTO> db;
	AccountDTO acc;
	public AccountDAO() {
		db = new HashMap<String, AccountDTO>();
		acc = new AccountDTO();
	}

	@Override
	public void insert(AccountDTO v) throws Exception {
		if(db.containsKey(v.getAccNo())) {
			throw new Exception("중복계좌 등록 오류");
		}
		db.put(v.getAccNo(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception("없는 계좌 삭제 요청 오류");
		}
		db.remove(k);
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		if(!db.containsKey(v.getAccNo())) {
			throw new Exception("없는계좌 update요청오류");
		}		
		db.put(v.getAccNo(), v);
	}

	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO obj = null;
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		Collection<AccountDTO> col = db.values();

		for (AccountDTO accData : col) {
			list.add(accData);
		}

		return list;
	}

	// 사용자의 계좌 조회
	// obj : 사용자의 id
	// Object obj = new String();
	@Override
	public List<AccountDTO> search(Object obj) throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		Collection<AccountDTO> col = db.values();
		
		for(AccountDTO data:col) {
			//계좌 중에서 id값이 obj와 같은 것들만 list에 담자
			if((acc.getHolder()).equals(obj)) {
				list.add(data);
			}
		}
		return list;
	}
				

}
