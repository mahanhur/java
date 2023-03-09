package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO> {
	HashMap<String, UserDTO> db = null;

	public UserDAO() {
		db = new HashMap<String, UserDTO>();
	}

	@Override
	public void insert(UserDTO v) throws Exception {
		if (db.containsKey(v.getId())) {
			throw new Exception("이미 존재하는 ID register시도 오류");
		}
		db.put(v.getId(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		if (!db.containsKey(k)) {
			throw new Exception("존재하지 않는 ID remove시도 오류");
		}
		db.remove(k);
	}

	@Override
	public void update(UserDTO v) throws Exception {
		if (!db.containsKey(v.getId())) {
			throw new Exception("존재하지 않는 ID modify시도 오류");
		}
		db.put(v.getId(), v);
	}

	@Override
	public UserDTO select(String k) throws Exception {
		UserDTO obj = new UserDTO();
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		Collection<UserDTO> col = db.values();
		for (UserDTO data : col) {
			list.add(data);
		}

		return list;
	}

}
