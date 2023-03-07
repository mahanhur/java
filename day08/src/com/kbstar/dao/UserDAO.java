package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO>{

	@Override
	public void insert(UserDTO v) {
		System.out.println(v.getId()+"님이 저장 되었습니다.");
	}

	@Override
	public void delete(String k) {
		System.out.println(k+"님의 정보가 삭제되었습니다.");		
	}

	@Override
	public void update(UserDTO v) {
		System.out.println(v.getId()+"님의 정보가 수정되었습니다.");
	}

}
